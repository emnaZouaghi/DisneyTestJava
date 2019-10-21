package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.typesafe.config.Config;

import models.Image;
import java.util.logging.*;

import play.cache.NamedCache;
import play.cache.SyncCacheApi;
import play.mvc.Controller;
import play.mvc.Result;
import services.ContentAPIService;
import utils.AppUtils;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	private Logger logger = Logger.getLogger("play");
	private static final String IMAGE_URL = "image.url";
	private static final String RANDOM_IMAGE_CACHE = "randomImg.cache";
	private static final String IMAGE_URL_SUFFIX = "/200/300";

	private final Config conf;
	@NamedCache("session-cache")
	private final SyncCacheApi cache;

	private JsonNode imagesAsJson;
	private ObjectMapper objectMapper = new ObjectMapper();
	private Image[] images = {};
	private List<String> listUrl = new ArrayList<String>();
	int id;

	@Inject
	private ContentAPIService wsClient;

	@Inject
	public HomeController(Config config, SyncCacheApi cache, ContentAPIService wsClient) {
		this.conf = config;
		this.cache = cache;
		this.wsClient = wsClient;
	}

	public Result index() {
		return ok(views.html.index.render());
	}

	/**
	 * getImage
	 * 
	 * @return Result
	 */
	public CompletionStage<Result> test() {
		id = AppUtils.getRandomId();
		if (cache.get("imgUrl") == null) {
			cache.set("imgUrl", id, conf.getInt(RANDOM_IMAGE_CACHE));
		} else {
			id = (cache.get("imgUrl"));
		}
		logger.info(this.conf.getString(IMAGE_URL) + "id/" + id + IMAGE_URL_SUFFIX);

		return this.wsClient.getURLImage(cache, conf)

				.thenApply(file -> {

					return ok(views.html.images.render(this.conf.getString(IMAGE_URL) + "id/" + id + IMAGE_URL_SUFFIX,
							null));
				});
	}

	/**
	 * getMultiple Images
	 * 
	 * @return CompletionStage<Result>
	 */
	public CompletionStage<Result> testMultiple() throws JsonProcessingException {

		return this.wsClient.getURLImages().thenApply(files -> {
			this.imagesAsJson = files.asJson();

			try {
				// mapping the result from JSON to JAVA
				this.images = this.objectMapper.treeToValue(imagesAsJson, Image[].class);
				Arrays.stream(this.images).filter(img -> Integer.parseInt(img.getId()) % 2 == 0)
						.map(image -> image.getDownload_url()).forEach(imageUrl -> this.listUrl.add(imageUrl));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			// render HTML
			return ok(views.html.images.render(null, this.listUrl));
		});

	}

}

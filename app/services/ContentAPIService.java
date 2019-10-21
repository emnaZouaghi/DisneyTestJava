package services;

import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.typesafe.config.Config;

import play.cache.SyncCacheApi;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import utils.AppUtils;
/**
 * @author zouaghi
 *
 */
public class ContentAPIService {
	
	private static final String IMAGE_URL = "image.url";
	private static final String IMAGE_URL_SUFFIX = "/200/300";
	private static final String IMAGES_URL_SUFFIX = "/v2/list";
	private Logger logger = Logger.getLogger("play");
	
	

	private final WSClient wsClient;
	private final Config config;

	@Inject
	public ContentAPIService(Config config, WSClient wsClient) {
		this.config = config;
		this.wsClient = wsClient;
	}

	/**
	 * 
	 * @return one Image
	 */
	public CompletionStage<WSResponse> getURLImage(SyncCacheApi cache, Config config) {
		int id = AppUtils.getRandomId();
        if (cache.get("imgUrl") == null) {
            cache.set("imgUrl", id, config.getInt("randomImg.cache"));
        } else {
            id = (cache.get("imgUrl"));
        }
        logger.info(this.config.getString(IMAGE_URL)+"id/"+id +IMAGE_URL_SUFFIX);
		return this.wsClient.url(this.config.getString(IMAGE_URL)+"id/" +id +IMAGE_URL_SUFFIX).get();
	}

	/**
	 * 
	 * @return Multiple Image
	 */
	public CompletionStage<WSResponse> getURLImages() {

		return wsClient.url(config.getString(IMAGE_URL)+IMAGES_URL_SUFFIX).get();

	}

}

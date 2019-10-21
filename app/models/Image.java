package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {

	private String id;
	private String author;
	private int width;
	private int height;
	private String url;
	private String download_url;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@JsonProperty("width")
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@JsonProperty("height")
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("download_url")
	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}

	public Image(String id, String author, int width, int height, String url, String download_url) {
		super();
		this.id = id;
		this.author = author;
		this.width = width;
		this.height = height;
		this.url = url;
		this.download_url = download_url;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

}

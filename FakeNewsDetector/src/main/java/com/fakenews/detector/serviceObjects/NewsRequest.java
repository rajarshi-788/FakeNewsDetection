package com.fakenews.detector.serviceObjects;

public class NewsRequest {
	
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public NewsRequest() {
        // no-args constructor needed for JSON deserialization
    }

	public NewsRequest(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "NewsRequest [text=" + text + "]";
	}

}

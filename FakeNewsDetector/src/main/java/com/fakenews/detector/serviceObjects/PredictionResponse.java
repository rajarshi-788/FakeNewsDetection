package com.fakenews.detector.serviceObjects;

import org.springframework.stereotype.Component;

@Component
public class PredictionResponse {

	private String prediction;

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}

	@Override
	public String toString() {
		return "PredictionResponse [prediction=" + prediction + "]";
	}

}

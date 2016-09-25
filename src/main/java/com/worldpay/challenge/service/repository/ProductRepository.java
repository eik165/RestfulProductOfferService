package com.worldpay.challenge.service.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.worldpay.challenge.model.Product;

public enum ProductRepository {
	instance;

	private Map<String, Product> productListing = new ConcurrentHashMap<String, Product>();

	private ProductRepository() {

		// some startup App data
		Product product = new Product("1001", "iPhone 6 mobile phone", "Eletronics", "Iphone 6 - 6th Generation smart phone", 520.75f, 20);
		productListing.put("1001", product);

		product = new Product("1002", "Beats Solo 2.0 On-Ear Headphones ", "Eletronics", "Sony MDR-XD200 : stereo headphones feature an open, supra-aural design for incredibly natural-sounding audio", 120.20f, 15);
		productListing.put("1002", product);

		product = new Product("1003", "Sony Wave", "Eletronics","Portable Stereo Bluetooth Speaker 10W High Power Output with Rechargeable battery providing 10hrs+ Playtime, Enhanced Bass system and Builtin Mic for Handsfree Calls. Great for Home, Office, Garden, BBQ and Party. Inputs: FM Radio, SD Card, USB and 3.5mm AUX", 161.60f, 10);
		productListing.put("1003", product);
	}

	public Map<String, Product> getProductListing() {
		return productListing;
	}

}

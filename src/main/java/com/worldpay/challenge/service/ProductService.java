package com.worldpay.challenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.worldpay.challenge.model.Product;
import com.worldpay.challenge.service.repository.ProductRepository;

public class ProductService {

	ProductRepository productDao;

	public ProductService() {
		productDao = ProductRepository.instance;
	}

	public void createProduct(Product product) {
		productDao.getProductListing().put(product.getId(), product);
	}

	public Product getProduct(String id) {
		return productDao.getProductListing().get(id);
	}

	public Map<String, Product> getProducts() {
		return productDao.getProductListing();
	}

	public List<Product> getProductAsList() {
		List<Product> productList = new ArrayList<Product>();
		productList.addAll(productDao.getProductListing().values());
		return productList;
	}

	public int getProductsCount() {
		return productDao.getProductListing().size();
	}

	public void deleteProduct(String id) {

		productDao.getProductListing().remove(id);
	}

	public Product update(Product activity) {

		// if not present insert product
		// else
		// update the product

		productDao.getProductListing().put(activity.getId(), activity);

		return activity;
	}

}

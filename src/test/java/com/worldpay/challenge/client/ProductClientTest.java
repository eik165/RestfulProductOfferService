package com.worldpay.challenge.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.worldpay.challenge.model.Product;

public class ProductClientTest {

	@Test
	public void testDelete() {
		ProductsClient client = new ProductsClient();
		
		client.delete("1002");
	}
	
	@Test
	public void testPut() {
		Product product = new Product();
		
		product.setId("1001");
		product.setName("iPhone 7 mobile phone");
		product.setCategory("Eletronics");
		product.setProductDescription("Iphone 7 - 7th Generation smart phone");
		product.setUnitSalePrice(615.50f);
		product.setNumberOfUnits(20);
		
		ProductsClient client = new ProductsClient();
		
		product = client.update(product);
		
		assertNotNull(product);
	}
	
	@Test
	public void testCreate() {
		ProductsClient client = new ProductsClient();
		
		Product product = new Product();
		product.setId("44435");
		product.setName("stepper");
		product.setCategory("office furniture");
		product.setProductDescription("stepper description");
		product.setUnitSalePrice(15.50f);
		product.setNumberOfUnits(90);
		
		product = client.create(product);
		
		assertNotNull(product);
	}
	
	@Test
	public void testGet() throws Exception {
		ProductsClient client = new ProductsClient();
		
		Product product = client.get("1001");
		
		System.out.println(product);
		
		assertNotNull(product);
	}
	
	@Test
	public void testGetList() {
		ProductsClient client = new ProductsClient();
		
		List<Product> products = client.get();
		
		System.out.println(products);
		
		assertNotNull(products);
	}
	
	@Test
	public void testGetProductCount() {
		ProductsClient client = new ProductsClient();
		
		String products = client.getProductCount();
		
		System.out.println(products);
		
		Assert.assertEquals("3", products);
	}
	

	@Test(expected=Exception.class)
	public void testGetWithNotFound() throws Exception {
		ProductsClient client = new ProductsClient();
		
		//7777 doesn't exist , should get an exception from client
		client.get("7777");
	}
}

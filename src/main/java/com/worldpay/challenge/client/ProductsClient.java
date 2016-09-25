package com.worldpay.challenge.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.worldpay.challenge.model.Product;

public class ProductsClient {

	private Client client;
	public static final String SERVER_URI = "http://localhost:8080/RestfulProductOfferService/rest/";
	
	public ProductsClient () {
		client = ClientBuilder.newClient();
	}
	
	public void delete(String productId) {
		WebTarget target = client.target(SERVER_URI);
		
		Response response = target.path("products/" + productId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
	}
	
	public Product get(String id) throws Exception {
		
		//http://localhost:8080/JSONRESTfulServices/rest/products/1234
		WebTarget target = client.target(SERVER_URI);
		
		Response response = target.path("products/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(response.getStatus() != 200) {
			//throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
			throw new Exception(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Product.class);
	}
	
	public List<Product> get () {
		WebTarget target = client.target(SERVER_URI);
		
		List<Product> response = target.path("products").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {});
		
		return response;
	}

	public String getProductCount () {
		WebTarget target = client.target(SERVER_URI);
		
		String response = target.path("products/count").request(MediaType.TEXT_PLAIN).get(String.class);
		
		return response;
	}

	public Product create(Product product) {
		//http://localhost:8080/JSONRESTfulServices/rest/products/
		WebTarget target = client.target(SERVER_URI);
		
		Response response = target.path("products")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(product, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Product.class);
	}

	public Product update(Product product) {
		WebTarget target = client.target(SERVER_URI);
		
		Response response = target.path("products/" + product.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(product, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Product.class);
	}

	
	
}

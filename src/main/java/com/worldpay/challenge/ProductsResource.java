package com.worldpay.challenge;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import com.worldpay.challenge.model.Product;
import com.worldpay.challenge.service.ProductService;

@Path("/products")
public class ProductsResource {

	private static final Logger LOGGER = Logger.getLogger(ProductsResource.class);

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	ProductService productService;

	public ProductsResource() {
		productService = new ProductService();
	}

	//this gets the products listing
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getProducts() {
		LOGGER.info("ProductsResource:getProducts");
		return productService.getProductAsList();
	}

	//This gets the count of total products
	// URI: /rest/products/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		LOGGER.info("ProductsResource:getCount");
		return String.valueOf(productService.getProductsCount());
	}

	//this will create product from parameters
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createProduct(@FormParam("id") String id,
			@FormParam("productname") String name,
			@FormParam("productcategory") String category,
			@FormParam("productdescription") String description,
			@FormParam("productsaleprice") float salePrice,
			@FormParam("numberofunits") int units,
			@Context HttpServletResponse servletResponse) throws IOException {
		
		LOGGER.info("ProductsResource:createProduct with params id="+id);

		Product product = new Product(id, name, category, description, salePrice, units);

		productService.createProduct(product);

		servletResponse.sendRedirect("./products/");
	}

	//this will create product from product 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Product createProduct(Product product) {
		
		LOGGER.info("ProductsResource:createProduct with product id="+product.getId());
		System.out.println(product.getName());
		System.out.println(product.getNumberOfUnits());
		
		productService.createProduct(product);
		
		return product;
	}
	
	//this will delete a product given id 
	@DELETE
	@Path("{productId}")//http:localhost:8080/JSONRESTfulServices/rest/products/1002
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response delete (@PathParam ("productId") String productId) {

		LOGGER.info("ProductsResource:delete id="+productId);
		System.out.println(productId);
		
		productService.deleteProduct(productId);
		
		return Response.ok().build();
	}

	
	//this will get a product detail given id 
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{productId}") //http:localhost:8080/JSONRESTfulServices/rest/products/1002
	public Response getProduct(@PathParam ("productId") String id) {

		LOGGER.info("ProductsResource:getProduct id="+id);
		
		Product product = productService.getProduct(id);
		
		if(product == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(product).build();
	}
	
	//this is to update an existing product
	@PUT
	@Path("{productId}")//http:localhost:8080/JSONRESTfulServices/rest/products/1002
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response update(Product product) {
		
		LOGGER.info("ProductsResource:update id="+product.getId());
		System.out.println(product.getId());
		
		product = productService.update(product);
		
		return Response.ok().entity(product).build();
		
	}

}
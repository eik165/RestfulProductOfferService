# RestfulProductOfferService
Restful Product Offer Service using Jersey

Using this Restful Webservice a supplier can post a product listing 

An offer is a proposal to sell a specific product or service under specific conditions. A merchant can offer goods for sale. Merchant can create an offer so that he can share it with my customers.
All merchant offers have shopper friendly descriptions, all offers priced up front in a defined currency.

# Implementation

This Service is implemented as a Maven project and dependency is managed with pom file provided.
It uses jeresy library.
The offerd products are stored in memory using a Concurrenct Hashmap.

Product is uniquely identified with product id.

There is a sample html form provided to simulate a supplier interaction index.html

Beides there is limited Junit tests provided to test the Restful web service ProductClientTest.java

The ProductClientTest assumes the webservice is running on local machine on port 8080


# Webservice Functionality

getProducts - this gets the products listing.

getCount - this gets the count of total products.

createProduct - this will create product from parameters.

delete  - this will delete a product given id.

getProduct  - this will get a product detail given id.

update - this is to update an existing product.




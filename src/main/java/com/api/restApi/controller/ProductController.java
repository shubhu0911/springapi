package com.api.restApi.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restApi.entity.Product;
import com.api.restApi.repository.ProductRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping()
public class ProductController {

	@Autowired
	ProductRepository repo;

	@GetMapping(path = "/product", produces = { "application/json" })
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@GetMapping(path = "/product/{productID}", produces = { "application/json" })
	public List<Product> getProduct(@PathVariable("productID") String productID) {
		return repo.findAll();
	}

	@PostMapping(path = "/product", produces = { "application/json" })
	@ResponseBody
	public Product addUser(@RequestBody Product product) {
		System.out.println(product.getProductID());
		repo.save(product);
		return product;
	}

	@DeleteMapping("/product/{productID}")
	public String deleteBook(@PathVariable Long productID) {

		Product product = repo.getOne(productID);
		repo.delete(product);
		return "deleted";
	}

	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping(path = "/product/search/{searchSub}", produces = { "application/json" })
	@ResponseBody
	public List<Product> fetchProducts(@PathVariable String searchSub) {
		List<Product> productList = null;
		productList = repo.findAll();
		List<Product> desiredList = new ArrayList<Product>();

		for (Product product : productList) {
			String brand = product.getProductBrand();
			String name = product.getProductName();
			String prodCode = product.getProductID();


			if (brand.contains(searchSub) || name.contains(searchSub)) {
				desiredList.add(product);
			}


			if (prodCode.equals(searchSub)) {
				desiredList.add(product);
			}


		}

		return desiredList;
	}
}

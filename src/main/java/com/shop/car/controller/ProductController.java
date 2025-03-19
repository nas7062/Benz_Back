package com.shop.car.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.shop.car.dto.Login;
import com.shop.car.dto.Model;
import com.shop.car.dto.Product;
import com.shop.car.service.ProductService;
import com.shop.car.service.UserService;
import com.shop.car.util.JwtTokenProvider;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	Map<String, Object> storage = new HashMap();

	@GetMapping("getAllProducts")
	public List<Product> getAllProducts() {
		try {
			Object o = storage.get("firstPageProducts");
			if (o == null) {
				List<Product> list = productService.getAllProducts();
				storage.put("firstPageProducts", list);
				return list;
			}

			return (List<Product>) o;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("getProduct/{id}")
	public Product getProductById(@PathVariable String id, @RequestHeader("Authorization") String token)
			throws Exception {
		try {
			return productService.getProductById(id); // 상품 정보 조회 후 반환

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

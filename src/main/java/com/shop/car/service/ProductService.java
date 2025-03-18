package com.shop.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.car.dao.ProductDao;
import com.shop.car.dto.Model;
import com.shop.car.dto.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getAllProducts() throws Exception {
		return productDao.getAllProducts();
	}
	/*
	 * public Product getProductById(String id) throws Exception { return
	 * productDao.getProductById(id); }
	 */
	
}

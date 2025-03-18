package com.shop.car.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.car.dto.Model;
import com.shop.car.service.ModelService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ModelController {
	
	@Autowired
	ModelService ModelService;
	
	Map<String,Object> storage=new HashMap();
	
	@GetMapping("getAllModels")
	public List<Model> getAllModels() {
		try {
			Object o=storage.get("firstPageProducts");
			
			if(o==null) {
				List<Model> list=ModelService.getAllModels();
				storage.put("firstPageProducts", list);
				return list;
			}
			
			return (List<Model>)o;
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	


}

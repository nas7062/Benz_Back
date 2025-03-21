package com.shop.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.car.dao.ModelDao;
import com.shop.car.dto.Model;

@Service
public class ModelService {
	
	@Autowired
	ModelDao modelDao;
	
	public List<Model> getAllModels() throws Exception {
		return modelDao.getAllModels();
	}
	
}

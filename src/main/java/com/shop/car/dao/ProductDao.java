package com.shop.car.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.shop.car.dto.Model;
import com.shop.car.dto.Product;

@Mapper  // ✅ MyBatis 매퍼 인터페이스 등록
public interface ProductDao {
    List<Product> getAllProducts() throws Exception;
    
     Product getProductById(String id) throws Exception;
}

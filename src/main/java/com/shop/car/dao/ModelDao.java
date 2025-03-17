package com.shop.car.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.shop.car.dto.Model;

@Mapper  // ✅ MyBatis 매퍼 인터페이스 등록
public interface ModelDao {
    List<Model> getAllModels() throws Exception;
}

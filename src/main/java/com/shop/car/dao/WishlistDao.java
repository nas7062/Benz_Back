package com.shop.car.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shop.car.dto.Wishlist;

@Mapper
public interface WishlistDao {
    
    // ✅ 위시리스트 추가 (user_email 사용)
    void addToWishlist(Wishlist wishlist);

    // ✅ 특정 사용자의 위시리스트 조회 (user_email 사용)
    List<Wishlist> getWishlistByUser(@Param("user_email") String user_email);

    // ✅ 특정 사용자의 위시리스트에서 차량 삭제 (user_email 사용)
    void removeFromWishlist(@Param("car_id") int car_id, @Param("user_email") String user_email);

    // ✅ 전체 위시리스트 조회
    List<Wishlist> getAllWishlist();
}

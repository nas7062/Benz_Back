package com.shop.car.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.shop.car.dto.Wishlist;

@Mapper
public interface WishlistDao {
    void addToWishlist(Wishlist wishlist);
    List<Wishlist> getWishlistByUser(Integer user_id);
    void removeFromWishlist(int id);

    // ✅ XML에서 정의되었으므로 Java 인터페이스에서 제거
    List<Wishlist> getAllWishlist();
}

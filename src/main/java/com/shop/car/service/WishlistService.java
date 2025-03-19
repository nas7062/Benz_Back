package com.shop.car.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.car.dao.WishlistDao;
import com.shop.car.dto.Wishlist;

@Service
public class WishlistService {

    @Autowired
    private WishlistDao wishlistDao;

    // ✅ 위시리스트 추가 (user_email 검증 추가)
    public void addToWishlist(Wishlist wishlist) {
        if (wishlist.getUser_email() == null || wishlist.getUser_email().trim().isEmpty()) {
            throw new IllegalArgumentException("⚠️ user_email 값이 존재하지 않습니다.");
        }
        wishlistDao.addToWishlist(wishlist);
    }

    // ✅ 전체 위시리스트 조회
    public List<Wishlist> getAllWishlist() {
        return wishlistDao.getAllWishlist();
    }

    // ✅ 특정 사용자의 위시리스트 조회 (user_id → user_email)
    public List<Wishlist> getWishlistByUser(String user_email) {
        if (user_email == null || user_email.trim().isEmpty()) {
            throw new IllegalArgumentException("⚠️ user_email 값이 존재하지 않습니다.");
        }
        return wishlistDao.getWishlistByUser(user_email);
    }

    // ✅ 특정 사용자의 위시리스트에서 차량 삭제 (user_id → user_email)
    public void removeFromWishlist(int car_id, String user_email) {
        if (user_email == null || user_email.trim().isEmpty()) {
            throw new IllegalArgumentException("⚠️ user_email 값이 존재하지 않습니다.");
        }
        wishlistDao.removeFromWishlist(car_id, user_email);
    }
}

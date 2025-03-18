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

    public void addToWishlist(Wishlist wishlist) {
        wishlistDao.addToWishlist(wishlist);
    }

    public List<Wishlist> getAllWishlist() {
        return wishlistDao.getAllWishlist(); // ✅ 전체 위시리스트 조회 추가
    }

    public List<Wishlist> getWishlistByUser(Integer user_id) {
        return wishlistDao.getWishlistByUser(user_id);
    }

    public void removeFromWishlist(int id) {
        wishlistDao.removeFromWishlist(id);
    }
}

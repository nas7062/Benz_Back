package com.shop.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.shop.car.dto.Wishlist;
import com.shop.car.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public String addToWishlist(@RequestBody Wishlist wishlist) {
        try {
            wishlistService.addToWishlist(wishlist);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    // ✅ 전체 위시리스트 조회 API 추가
    @GetMapping("")
    public List<Wishlist> getAllWishlist() {
        return wishlistService.getAllWishlist();
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlistByUser(@PathVariable Integer userId) {
        return wishlistService.getWishlistByUser(userId);
    }

    @DeleteMapping("/remove/{id}")
    public String removeFromWishlist(@PathVariable int id) {
        try {
            wishlistService.removeFromWishlist(id);
            return "deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}

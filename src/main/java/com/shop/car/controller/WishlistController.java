package com.shop.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import com.shop.car.dto.Wishlist;
import com.shop.car.service.UserService;
import com.shop.car.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
public class WishlistController {

    private static final Logger logger = LoggerFactory.getLogger(WishlistController.class);

    @Autowired
    private WishlistService wishlistService;
    
    @Autowired
    UserService userService;
    // ✅ 위시리스트 추가 (user_email 기반)
    @PostMapping("/add")
    public ResponseEntity<String> addToWishlist(@RequestBody Wishlist wishlist,@RequestHeader("Authorization") String token) {
        try {
            if (wishlist.getUser_email() == null || wishlist.getUser_email().trim().isEmpty()) {
            	
                logger.error("⚠️ user_email 값이 존재하지 않습니다!");
                return ResponseEntity.badRequest().body("⚠️ user_email 값이 없습니다.");
            }
            userService.checkToken(token);
            wishlistService.addToWishlist(wishlist);
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            logger.error("⚠️ 위시리스트 추가 중 오류 발생", e);
            return ResponseEntity.status(500).body("error: " + e.getMessage());
        }
    }


    // ✅ 전체 위시리스트 조회
    @GetMapping("")
    public ResponseEntity<List<Wishlist>> getAllWishlist() {
        try {
            List<Wishlist> wishlist = wishlistService.getAllWishlist();
            return ResponseEntity.ok(wishlist);
        } catch (Exception e) {
            logger.error("⚠️ Error retrieving wishlist", e);
            return ResponseEntity.status(500).build();
        }
    }

    // ✅ 특정 사용자의 위시리스트 조회 (user_id → user_email)
    @GetMapping("/{userEmail}")
    public ResponseEntity<List<Wishlist>> getWishlistByUser(@PathVariable String userEmail, @RequestHeader("Authorization") String token) {
        try {
            if (userEmail == null || userEmail.trim().isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }
            userService.checkToken(token);
            List<Wishlist> wishlist = wishlistService.getWishlistByUser(userEmail);
            return ResponseEntity.ok(wishlist);
        } catch (Exception e) {
            logger.error("⚠️ Error retrieving wishlist for user: " + userEmail, e);
            return ResponseEntity.status(500).build();
        }
    }

    // ✅ 위시리스트 항목 삭제 (user_email 기반)
    @DeleteMapping("/remove/{carId}/{userEmail}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable int carId, @PathVariable String userEmail , @RequestHeader("Authorization") String token) {
        try {
            if (userEmail == null || userEmail.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("⚠️ user_email 값이 없습니다.");
            }
            userService.checkToken(token);
            wishlistService.removeFromWishlist(carId, userEmail);
            return ResponseEntity.ok("deleted");
        } catch (Exception e) {
            logger.error("⚠️ Error deleting wishlist item. Car ID: " + carId + ", User Email: " + userEmail, e);
            return ResponseEntity.status(500).body("error");
        }
    }
}

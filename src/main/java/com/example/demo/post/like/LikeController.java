package com.example.demo.post.like;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{postId}/user/{userId}")
    public ResponseEntity<Void> addLike(@PathVariable Long userId, @PathVariable Long postId) {
        likeService.addLike(userId, postId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}/user/{userId}")
    public ResponseEntity<Void> removeLike(@PathVariable Long userId, @PathVariable Long postId) {
        likeService.removeLike(userId, postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


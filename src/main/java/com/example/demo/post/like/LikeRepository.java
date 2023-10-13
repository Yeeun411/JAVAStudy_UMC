package com.example.demo.post.like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    void deleteByUserIdAndPostId(Long userId, Long postId);
}

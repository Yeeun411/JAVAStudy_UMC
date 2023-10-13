package com.example.demo.post.like;

import com.example.demo.post.PostEntity;
import com.example.demo.post.PostRepository;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void addLike(Long userId, Long postId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        LikeEntity like = new LikeEntity();
        like.setUser(user);
        like.setPost(post);

        likeRepository.save(like);
    }

    @Transactional
    public void removeLike(Long userId, Long postId) {
        likeRepository.deleteByUserIdAndPostId(userId, postId);
    }
}


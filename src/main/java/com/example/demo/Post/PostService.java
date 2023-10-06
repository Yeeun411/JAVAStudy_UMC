package com.example.demo.Post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.User.UserEntity;
import com.example.demo.User.UserRepository;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostEntity createPost(PostDto dto) {
        PostEntity post = new PostEntity();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCreatedAt(LocalDateTime.now());

        UserEntity user = userRepository.findById(Math.toIntExact(dto.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        post.setUser(user);
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostDto> getPostsByTitle(String title) {
        return postRepository.findByTitle(title).stream()
                .map(post -> new PostDto(
                        post.getPostId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getCreatedAt().toString(),
                        post.getUser().getUserId()
                ))
                .collect(Collectors.toList());
    }
}


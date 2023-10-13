package com.example.demo.post.like;

import com.example.demo.post.PostEntity;
import com.example.demo.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private PostEntity post;
}
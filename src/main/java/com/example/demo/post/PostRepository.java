package com.example.demo.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    List<PostEntity> findByTitle(String title);

    void deleteByTitle(String title);
}


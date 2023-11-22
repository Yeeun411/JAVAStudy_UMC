package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<Member> findByEmail(String email); //이메일로 Member 찾기
    boolean existsByEmail(String email); //이메일로 Member 존재 여부 확인
}

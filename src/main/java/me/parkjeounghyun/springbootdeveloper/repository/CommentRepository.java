package me.parkjeounghyun.springbootdeveloper.repository;

import me.parkjeounghyun.springbootdeveloper.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

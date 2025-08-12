package me.parkjeounghyun.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.parkjeounghyun.springbootdeveloper.config.error.exception.ArticleNotFoundException;
import me.parkjeounghyun.springbootdeveloper.config.error.exception.UserUnauthorizedException;
import me.parkjeounghyun.springbootdeveloper.domain.Article;
import me.parkjeounghyun.springbootdeveloper.domain.Comment;
import me.parkjeounghyun.springbootdeveloper.dto.AddArticleRequest;
import me.parkjeounghyun.springbootdeveloper.dto.AddCommentRequest;
import me.parkjeounghyun.springbootdeveloper.dto.UpdateArticleRequest;
import me.parkjeounghyun.springbootdeveloper.repository.BlogRepository;
import me.parkjeounghyun.springbootdeveloper.repository.CommentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request, String userName) {
        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);
    }

    public void delete(long id) {
        //blogRepository.deleteById(id);
        Article article = blogRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        authorizeArticleAuthor(article);
        blogRepository.delete(article);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }

    public Comment addComment(AddCommentRequest request, String userName) {
        Article article = blogRepository.findById(request.getArticleId())
                .orElseThrow(() -> new IllegalArgumentException("not found: " + request.getArticleId()));

        return commentRepository.save(request.toEntity(userName, article));
    }

    // 게시글을 작성한 유저인지 확인
    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if (!article.getAuthor().equals(userName)) {
            throw new UserUnauthorizedException();
        }
    }
}

package top.test.boot.database.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.test.boot.database.entity.Article;
import top.test.boot.database.service.impl.ArticleJpaServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleJpaServiceTest {

    @Resource
    ArticleJpaServiceImpl articleJpaService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .author("王五")
                .content("Spring Boot")
                .title("Spring BOOt")
                .build();
        articleJpaService.saveArticle(article);
    }

    @Test
    void updateArticle() {
        Article article = Article.builder()
                .author("王五1")
                .content("Spring Boot")
                .title("Spring BOOt")
                .id(3)
                .build();
        articleJpaService.updateArticle(article);
    }

    @Test
    void getArticleById() {
        articleJpaService.getArticleById(2);
    }

    @Test
    void findAll() {
        articleJpaService.findAll();
    }

    @Test
    void deleteArticle() {
        articleJpaService.deleteArticle(2);
    }
}
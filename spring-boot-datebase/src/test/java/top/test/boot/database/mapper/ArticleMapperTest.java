package top.test.boot.database.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.test.boot.database.entity.Article;


@SpringBootTest
class ArticleMapperTest {

    @Autowired
   private ArticleMapper articleMapper;

    @Test
    void insertArticle() {
        Article article = Article.builder()
                .author("lucy")
                .content("Spring Boot2")
                .title("Spring BOOt2")
                .build();
        articleMapper.insertArticle(article);
    }
}
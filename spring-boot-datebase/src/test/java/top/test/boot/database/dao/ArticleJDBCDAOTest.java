package top.test.boot.database.dao;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.test.boot.database.entity.Article;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleJDBCDAOTest {

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Test
    void save(){
        Article article = Article.builder()
                .author("李四")
                .content("Spring Boot")
                .title("Spring BOOt")
                .build();
        articleJDBCDAO.save(article);
    }

    @Test
    void update() {
        Article article = Article.builder()
                .author("李四更改")
                .content("Spring Boot 2")
                .title("Spring BOOt change")
                .id(1)
                .build();
        articleJDBCDAO.updateById(article);
    }

    @Test
    void findOne() {
        log.info("查询一个:{}", articleJDBCDAO.findById(1).toString());
    }
    @Test
    void findAll() {
        log.info("查询所有:{}", articleJDBCDAO.findAll().toString());
    }
    @Test
    void del() {
        articleJDBCDAO.deleteById(1);
        log.info("删除成功");
    }
}
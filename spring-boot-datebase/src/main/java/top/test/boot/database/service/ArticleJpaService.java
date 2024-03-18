package top.test.boot.database.service;

import top.test.boot.database.entity.Article;

import java.util.List;

/**
 * @author JXS
 */
public interface ArticleJpaService {

    /**
     * 新增
     * @param article
     * @return
     */
    void saveArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticle(int id);
}

package top.test.boot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.test.boot.database.entity.Article;

/**
 * @author JXS
 */
public interface ArticleJpaDAO extends JpaRepository<Article,Integer> {


}

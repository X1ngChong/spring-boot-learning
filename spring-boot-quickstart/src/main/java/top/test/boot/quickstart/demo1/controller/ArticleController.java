package top.test.boot.quickstart.demo1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.test.boot.quickstart.demo1.pojo.Article;
import top.test.boot.quickstart.demo1.pojo.Reader;
import top.test.boot.quickstart.demo1.response.AjaxResponse;

import java.util.Date;
import java.util.List;

/**
 * @author JXS
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/articles")
public class ArticleController {

    /**
     * 在路径中加入参数 根据id查询文章
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        List<Reader> readerList = List.of(Reader.builder().name("aa").age(12).build(), Reader.builder().name("bbb").age(13).build());
        Article article = Article.builder()
                .id(id)
                .author("xxx")
                .content("SpringBoot 从青铜到王者")
                .title("SpringBoot")
                .readerList(readerList)
                .createTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }


    /**
     * 测试时发送id:{} 这样的数据测试  根据id查询文章
     * @param id
     * @return
     */
    @GetMapping()
    public AjaxResponse getArticleByParam(@RequestParam("id") long id) {
        List<Reader> readerList = List.of(Reader.builder().name("aaa").age(12).build(), Reader.builder().name("bbb").age(13).build());
        Article article = Article.builder()
                .id(id)
                .author("xxx")
                .content("SpringBoot 从青铜到王者")
                .title("SpringBoot")
                .readerList(readerList)
                .createTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }


    /**
     * 获取全部的数据
     * @return
     */
    @GetMapping("all")
    public AjaxResponse selectAll() {
        List<Reader> readerList = List.of(Reader.builder().name("aaa").age(12).build(), Reader.builder().name("bbb").age(13).build());
        Article article = Article.builder()
                .id(111L)
                .author("xxx")
                .content("SpringBoot")
                .title("SpringBoot")
                .readerList(readerList)
                .createTime(new Date())
                .build();
        Article article2 = Article.builder()
                .id(222L)
                .author("xxx")
                .content("Java")
                .title("Java")
                .readerList(readerList)
                .createTime(new Date())
                .build();
        return AjaxResponse.success(List.of(article, article2));
    }


    /**
     *  发送JSON对象传入数据
     * @param article
     * @return
     */
    @PostMapping("body")
    public AjaxResponse saveArticleByJsonBody(@RequestBody Article article) {
        log.info("saveArticle:" + article);
        return AjaxResponse.success(article);
    }

    /**
     *参数用键值对
     * @param id
     * @param author
     * @param title
     * @param content
     * @param createTime
     * @return
     */
    @PostMapping("param")
    public AjaxResponse saveArticleByParams(
            @RequestParam long id,
            @RequestParam(value = "author", defaultValue = "xxxx", required = false) String author,
            @RequestParam String title,
            @RequestParam String content,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam Date createTime) {
        Article article = Article.builder()
                .id(id)
                .title(title)
                .author(author)
                .content(content)
                .createTime(createTime)
                .build();
        return AjaxResponse.success(article);
    }

    /**
     *参数只有一个formData {"id":11,"name":xx} 这样类型的字符串 传递参数
     * @param formData
     * @return
     */
    @PostMapping("form")
    public AjaxResponse saveArticleByFormData(@RequestParam("formData") String formData) {
        log.info("formData: " + formData);
        // 用Jackson反序列化将字符串转为Java对象
        ObjectMapper mapper = new ObjectMapper();
        Article article = null;
        try {
            article = mapper.readValue(formData, Article.class);
            log.info("article: " + article);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return AjaxResponse.success(article);
    }


    /**
     * 传入JSON对象插入数据
     * @param article
     * @return
     */
    @PutMapping()
    public AjaxResponse updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            log.error("没有id");
            //article.id是必传参数，因为通常根据id去修改数据
        }
        log.info("updateArticle:" + article);
        return AjaxResponse.success(article);
    }

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }

}

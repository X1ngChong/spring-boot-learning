package top.test.boot.database.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author JXS
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //*
@Table(name = "t_article") //可选
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 32)
    private String author;

    private String title;

    private String content;
}

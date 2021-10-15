package com.iuliana.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "post")
@AllArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @TableGenerator(name = "id_generator", initialValue = 2, allocationSize = 1)
    @GeneratedValue(generator = "id_generator")
    private int id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    @Column(name = "full_text")
    private String fullText;

    @Column(name = "last_modification")
    private Date lastTimeModified;

    private long views;

    @ManyToOne
    @JoinColumn(name="id_author", nullable=false)
    private User author;

    public Post() {
    }

    public Post(Category category, String title, String fullText, Date lastTimeModified, long views, User author) {
        this.category = category;
        this.title = title;
        this.fullText = fullText;
        this.lastTimeModified = lastTimeModified;
        this.views = views;
        this.author = author;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format("Category: %s | Title: %s | Text: %s | Date: %s | Views: %d | Author: %s",
                category, title, fullText, lastTimeModified.toLocalDate().format(formatter), views, author);
    }
}

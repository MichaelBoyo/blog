package com.boyo.blog.data.repositories;

import com.boyo.blog.data.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}

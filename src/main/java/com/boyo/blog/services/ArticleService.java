package com.boyo.blog.services;

import com.boyo.blog.data.models.Article;
import com.boyo.blog.dtos.requests.ArticleRequest;


public interface ArticleService {
    Article saveArticle(ArticleRequest articleRequest);

    String updateArticle(Integer id, ArticleRequest articleRequest);

    String deleteArticle(Integer id);

    Article getArticle(Integer id);
}

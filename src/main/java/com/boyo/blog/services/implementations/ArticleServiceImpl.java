package com.boyo.blog.services.implementations;

import com.boyo.blog.data.models.Article;
import com.boyo.blog.data.repositories.ArticleRepository;
import com.boyo.blog.dtos.requests.ArticleRequest;
import com.boyo.blog.exceptions.ArticleNotFoundException;
import com.boyo.blog.services.ArticleService;
import com.boyo.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article saveArticle(ArticleRequest articleRequest) {
        Article article = new Article();
        Mapper.mapArticleReQuestToArticle(articleRequest, article);
        return articleRepository.save(article);

    }

    @Override
    public String updateArticle(Integer id, ArticleRequest articleRequest) {
        var article = getArticle(id);
        Mapper.mapArticleReQuestToArticle(articleRequest,article);
        articleRepository.save(article);
        return "updated successfully";
    }

    @Override
    public String deleteArticle(Integer id) {
        var article = getArticle(id);
        articleRepository.delete(article);
        return "Deleted Successfully";
    }

    @Override
    public Article getArticle(Integer id) {
        return articleRepository.findById(id).orElseThrow(
                ()->new ArticleNotFoundException("article with id-> "+id+" not found"));
    }
}

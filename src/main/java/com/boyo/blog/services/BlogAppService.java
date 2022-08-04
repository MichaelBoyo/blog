package com.boyo.blog.services;

import com.boyo.blog.dtos.requests.AddArticleRequest;


public interface BlogAppService {
    String addArticle(AddArticleRequest request);
}

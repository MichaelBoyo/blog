package com.boyo.blog.services;

import com.boyo.blog.dtos.requests.AddArticleRequest;
import com.boyo.blog.dtos.requests.CommentRequest;


public interface BlogAppService {
    String addArticle(AddArticleRequest request);

    String addComment(CommentRequest commentRequest);
}

package com.boyo.blog.utils;

import com.boyo.blog.data.models.Article;
import com.boyo.blog.data.models.Blog;
import com.boyo.blog.data.models.Comment;
import com.boyo.blog.data.models.User;
import com.boyo.blog.dtos.requests.*;

import java.util.Objects;


public class Mapper {

    public static void mapRequestToUSer(RegisterUserRequest registerUserRequest, User user) {
        user.setUsername(registerUserRequest.getUsername());
    }

    public static void mapArticleReQuestToArticle(ArticleRequest articleRequest, Article article) {
        if(articleRequest.getTitle() != null && !Objects.equals(articleRequest.getTitle(), "")){
            article.setTitle(article.getTitle());
        }
        if(articleRequest.getBody() != null && !Objects.equals(articleRequest.getBody(), "")){
            article.setBody(articleRequest.getBody());
        }


    }

    public static void mapBlogRequestToBlog(BlogRequest blogRequest, Blog blog) {
        if(blog.getBlogName() != null && !Objects.equals(blog.getBlogName(), "")){
            blog.setBlogName(blogRequest.getBlogName());
        }
    }

    public static void mapCommentRequestToComment(CommentRequest commentRequest, Comment comment) {
        if(commentRequest.getBody() != null && !Objects.equals(commentRequest.getBody(), "")){
            comment.setBody(commentRequest.getBody());
        }
    }

    public static void MapUpdateRequestToUser(UpdateUserRequest request, User user) {
        if(request.getUsername()!= null && !Objects.equals(request.getUsername(), "")){
            user.setUsername(request.getUsername());
        }
    }

    public static void mapAddArticleReqToArticleReq(ArticleRequest articleRequest, AddArticleRequest request) {
        articleRequest.setTitle(request.getTitle());
        articleRequest.setBody(request.getBody());
    }

    public static void mapAddArticleReqToBlogRequest(AddArticleRequest request, BlogRequest blogRequest) {
        blogRequest.setBlogName(request.getBlogName());
    }
}

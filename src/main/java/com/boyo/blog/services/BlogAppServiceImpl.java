package com.boyo.blog.services;

import com.boyo.blog.data.models.Comment;
import com.boyo.blog.dtos.requests.AddArticleRequest;
import com.boyo.blog.dtos.requests.ArticleRequest;
import com.boyo.blog.dtos.requests.BlogRequest;
import com.boyo.blog.dtos.requests.CommentRequest;
import com.boyo.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogAppServiceImpl implements BlogAppService {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;
    @Override
    public String addArticle(AddArticleRequest request) {
        var articleRequest = new ArticleRequest();
        Mapper.mapAddArticleReqToArticleReq(articleRequest,request);

        var article = articleService.saveArticle(articleRequest);
        var user = userService.getUserByUsername(request.getUsername());
        var blog = blogService.findBlogByName(request.getBlogName());
        if(blog== null){
            var blogRequest = new BlogRequest();
            Mapper.mapAddArticleReqToBlogRequest(request,blogRequest);
            blog = blogService.saveBlog(blogRequest);
        }
        blog.getArticles().add(article);
        blogService.reSave(blog);
        user.setBlog(blog);
        userService.reSave(user);


        return "Article added Successfully";
    }

    @Override
    public String addComment(CommentRequest commentRequest) {
        var article = articleService.getArticle(commentRequest.getArticleId());
        var comment = commentService.saveComment(commentRequest);

        article.getComments().add(comment);
        articleService.reSave(article);
        return "comment added successfully";
    }
}

package com.boyo.blog.services;


import com.boyo.blog.data.models.Blog;
import com.boyo.blog.dtos.requests.BlogRequest;

public interface BlogService {
    Blog saveBlog(BlogRequest blogRequest);

    String updateBlog(Integer id, BlogRequest blogRequest);

    String deleteBlog(Integer id);

    Blog getBlog(Integer id);

    void reSave(Blog blog);

    Blog findBlogByName(String blogName);
}

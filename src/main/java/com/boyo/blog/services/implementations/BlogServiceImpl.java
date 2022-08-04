package com.boyo.blog.services.implementations;

import com.boyo.blog.data.models.Blog;
import com.boyo.blog.data.repositories.BlogRepository;
import com.boyo.blog.dtos.requests.BlogRequest;
import com.boyo.blog.exceptions.BlogNotFoundException;
import com.boyo.blog.services.BlogService;
import com.boyo.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog saveBlog(BlogRequest blogRequest) {
        Blog blog = new Blog();
        Mapper.mapBlogRequestToBlog(blogRequest,blog);
        return blogRepository.save(blog);
    }

    @Override
    public String updateBlog(Integer id, BlogRequest blogRequest) {
        var blog = getBlog(id);
        Mapper.mapBlogRequestToBlog(blogRequest,blog);
        return "updated successfully";
    }

    @Override
    public String deleteBlog(Integer id) {
        var blog = getBlog(id);
        blogRepository.delete(blog);
        return null;
    }

    @Override
    public Blog getBlog(Integer id) {
        return blogRepository.findById(id).orElseThrow(
                ()->new BlogNotFoundException("blog with id-> "+id+" not found"));
    }

    @Override
    public void reSave(Blog blog) {
        blogRepository.save(blog);
    }
}

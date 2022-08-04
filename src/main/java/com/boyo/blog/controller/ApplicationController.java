package com.boyo.blog.controller;

import com.boyo.blog.dtos.requests.AddArticleRequest;
import com.boyo.blog.dtos.requests.CommentRequest;
import com.boyo.blog.services.BlogAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
public class ApplicationController {
    @Autowired
    private BlogAppService blogAppService;

    @PutMapping("/article")
    public ResponseEntity<?> addArticle(@RequestBody AddArticleRequest request) {
        return new ResponseEntity<>(blogAppService.addArticle(request), HttpStatus.OK);
    }
    @PatchMapping("/article")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest commentRequest){
        return new ResponseEntity<>(blogAppService.addComment(commentRequest), HttpStatus.OK);
    }

}

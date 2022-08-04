package com.boyo.blog.services;

import com.boyo.blog.data.models.Comment;

import com.boyo.blog.dtos.requests.CommentRequest;

public interface CommentService {
    Comment saveComment(CommentRequest articleRequest);

    String updateComment(Integer id, CommentRequest articleRequest);

    String deleteComment(Integer id);

    Comment getComment(Integer id);
}

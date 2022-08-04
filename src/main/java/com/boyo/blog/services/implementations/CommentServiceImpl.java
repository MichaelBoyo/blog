package com.boyo.blog.services.implementations;

import com.boyo.blog.data.models.Comment;
import com.boyo.blog.data.repositories.CommentRepository;
import com.boyo.blog.dtos.requests.CommentRequest;
import com.boyo.blog.exceptions.CommentNotFoundException;
import com.boyo.blog.services.CommentService;
import com.boyo.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment saveComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        Mapper.mapCommentRequestToComment(commentRequest,comment);
        return commentRepository.save(comment);
    }

    @Override
    public String updateComment(Integer id, CommentRequest commentRequest) {
        var comment  =getComment(id);
        Mapper.mapCommentRequestToComment(commentRequest,comment);
        return "comment updated successfully";
    }

    @Override
    public String deleteComment(Integer id) {
        var comment = getComment(id);
        commentRepository.delete(comment);
        return "comment deleted successfully";
    }

    @Override
    public Comment getComment(Integer id) {
        return commentRepository.findById(id).orElseThrow(
                ()->new CommentNotFoundException("comment with id-> "+id+" not found"));
    }
}

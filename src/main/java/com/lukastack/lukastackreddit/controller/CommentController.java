package com.lukastack.lukastackreddit.controller;

import com.lukastack.lukastackreddit.api.CommentApi;
import com.lukastack.lukastackreddit.dto.CommentDto;
import com.lukastack.lukastackreddit.persistence.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController implements CommentApi {

    private final CommentService commentService;

    // TODO return body?
    @Override
    public ResponseEntity<Void> createComment(CommentDto commentDto) {

        commentService.createComment(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CommentDto>> getAllCommentsByPost(Long postId) {

        return ResponseEntity.ok(commentService.getCommentByPost(postId));
    }

    @Override
    public ResponseEntity<List<CommentDto>> getAllCommentByUser(String username) {

        return ResponseEntity.ok(commentService.getCommentByUser(username));
    }
}

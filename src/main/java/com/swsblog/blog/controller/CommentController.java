package com.swsblog.blog.controller;

import com.swsblog.blog.domain.Comment;
import com.swsblog.blog.dto.CommentRequestDto;
import com.swsblog.blog.security.UserDetailsImpl;
import com.swsblog.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/comments/{postId}")
    public List<Comment> getComments(@PathVariable Long postId){
        return commentService.getComments(postId);
    }

    @PostMapping("api/comments/{postId}")
    public Comment createComment(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl user, @RequestBody CommentRequestDto commentRequestDto){
        String username = user.getUsername();
        return commentService.saveComment(postId, username, commentRequestDto);
    }

    @PutMapping("api/comments/{id}")
    public boolean updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(id, requestDto);
    }

    @DeleteMapping("api/comments/{id}")
    public boolean deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}

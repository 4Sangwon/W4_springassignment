package com.swsblog.blog.service;

import com.swsblog.blog.domain.Comment;
import com.swsblog.blog.dto.CommentRequestDto;
import com.swsblog.blog.repository.CommentRepository;
import com.swsblog.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getComments(Long postId) {
        return commentRepository.findAllByPostIdOrderByModifiedAtDesc(postId);
    }

    public Comment saveComment(Long postId, String username, CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(postId, username, commentRequestDto);
        return commentRepository.save(comment);
    }

    @Transactional
    public boolean updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
        return true;
    }

    @Transactional
    public boolean deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        commentRepository.deleteById(id);
        return true;
    }
}

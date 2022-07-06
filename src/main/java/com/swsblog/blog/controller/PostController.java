package com.swsblog.blog.controller;

import com.swsblog.blog.domain.Post;
import com.swsblog.blog.dto.PostDeleteRequestDto;
import com.swsblog.blog.dto.PostRequestDto;
import com.swsblog.blog.dto.PostUpdateRequestDto;
import com.swsblog.blog.repository.PostRepository;
import com.swsblog.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();
        return postRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @PostMapping("/api/posts")
    public Post createMemo(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @PutMapping("/api/posts/{id}")
    public boolean updatePost(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public boolean deletePost(@PathVariable Long id, @RequestBody PostDeleteRequestDto requestDto) {
        return postService.delete(id, requestDto);
    }
}

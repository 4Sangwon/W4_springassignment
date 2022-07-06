package com.swsblog.blog.post;


import com.swsblog.blog.post.domain.Post;
import com.swsblog.blog.post.dto.PostDeleteRequestDto;
import com.swsblog.blog.post.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public boolean update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(post.getPassword().equals(requestDto.getPassword())){
            post.update(requestDto);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean delete(Long id, PostDeleteRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if(post.getPassword().equals(requestDto.getPassword())){
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

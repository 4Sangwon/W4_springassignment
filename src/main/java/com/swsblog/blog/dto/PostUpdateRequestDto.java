package com.swsblog.blog.post.dto;

import lombok.Getter;

@Getter
public class PostUpdateRequestDto {
    private String contents;
    private String password;
}

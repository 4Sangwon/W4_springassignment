package com.swsblog.blog.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class SignupRequestDto {
    @NotBlank
    @Length(min=3,message = "닉네임은 최소 3자 이상입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "닉네임은 알파벳 대소문자 또는 숫자로만 이루어져있어야 합니다.")
    private String username;

    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}
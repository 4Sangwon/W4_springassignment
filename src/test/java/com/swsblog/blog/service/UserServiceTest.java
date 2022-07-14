package com.swsblog.blog.service;

import com.swsblog.blog.domain.User;
import com.swsblog.blog.dto.SignupRequestDto;
import com.swsblog.blog.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    PasswordEncoder passwordEncoder;

    @Nested
    @DisplayName("회원가입 검증")
    class RegisterUser {

        private String username = "us";
        private String password = "password";
        private String passwordChk = "password";

        @Nested
        @DisplayName("회원가입 성공")
        class RegisterUserSuccess {
            @Test
            @DisplayName("회원가입 성공")
            void success() {
                SignupRequestDto signupRequestDto =
                        new SignupRequestDto.test(username, password, passwordChk, false, "");
                UserService userService = new UserService(userRepository, passwordEncoder);
                //getPassword null에러 --> 시큐리티.....
                User user = userService.registerUser(signupRequestDto);
                assertThat(password.equals(passwordChk));
            }
        }
    }
}

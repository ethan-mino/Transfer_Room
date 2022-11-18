package com.transfer.room.user.controller;

import com.transfer.room.config.security.JwtTokenProvider;
import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.service.UserService;
import com.transfer.room.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService,
                          PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody UserDto userDto) throws AuthenticationException {
        String userEmail = userDto.getUserEmail();
        UserDto queriedUser = userService.findUserByUserEmail(userEmail);

        boolean isAuthFailed = (queriedUser == null || !passwordEncoder.matches(userDto.getUserPassword(), queriedUser.getUserPassword()));

        // 아이디 또는 비밀번호가 일치하지 않는 경우
        if(isAuthFailed){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }else{  // 아이디와 비밀번호가 일치하는 경우
            ApiResponse<String> apiResponse = new ApiResponse<>();

            String token = jwtTokenProvider.createToken(userEmail);  // token 생성
            apiResponse.setData(token);
            return ResponseEntity.ok(apiResponse);
        }
    }
}
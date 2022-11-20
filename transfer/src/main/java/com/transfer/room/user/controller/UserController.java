package com.transfer.room.user.controller;

import com.transfer.room.config.security.JwtTokenProvider;
import com.transfer.room.user.dto.LoginDto;
import com.transfer.room.user.dto.UserDto;
import com.transfer.room.user.service.UserService;
import com.transfer.room.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public ResponseEntity<ApiResponse<String>> login(@RequestBody LoginDto loginDto) throws AuthenticationException {
        String userEmail = loginDto.getUserEmail();
        UserDto queriedUser = userService.findUserByUserEmail(userEmail);

        boolean isAuthFailed = (queriedUser == null || !passwordEncoder.matches(loginDto.getUserPassword(), queriedUser.getUserPassword()));

        // 아이디 또는 비밀번호가 일치하지 않는 경우
        if(isAuthFailed){
            // TODO : Exception processing
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }else{  // 아이디와 비밀번호가 일치하는 경우
            ApiResponse<String> apiResponse = new ApiResponse<>();

            String token = jwtTokenProvider.createToken(userEmail);  // token 생성
            apiResponse.setData(token);
            return ResponseEntity.ok(apiResponse);
        }
    }

    @PostMapping("/signup") // 회원가입
    public ResponseEntity<ApiResponse<UserDto>> signup(
            @Valid @RequestBody UserDto userDto,
            BindingResult bindingResult) {

        // TODO: 2022-11-20 DTO가 엔티티의 모든 정보를 담고 있음. 별도의 반환용 DTO가 필요(현재 생성시간, 업데이트 시간이 들어가고 있음.)
        ApiResponse<UserDto> apiResponse = new ApiResponse<>();

        if(bindingResult.hasErrors()){
            // TODO : Exception processing
//            throw new InvalidInputException();
            return ResponseEntity.badRequest().build();
        }else{
            String userEmail = userDto.getUserEmail();
            String password = userDto.getUserPassword();
            String encodedPassword = passwordEncoder.encode(password);  // 비밀번호 암호화

            userDto.setUserPassword(encodedPassword);
            try{
                boolean isUserAdded = userService.addUser(userDto);
                if(isUserAdded){ // 계정이 생성된 경우
                    UserDto createdUser = userService.findUserByUserEmail(userEmail);
                    apiResponse.setData(createdUser);
                    return ResponseEntity.ok(apiResponse);
                }else{  // 계정 생성에 실패한 경우
                    // TODO : Exception processing
                    return ResponseEntity.internalServerError().build();
                }
            }catch (Exception e){
                // TODO : Exception Processing
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}
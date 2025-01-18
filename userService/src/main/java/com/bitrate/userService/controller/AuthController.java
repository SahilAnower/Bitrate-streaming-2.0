package com.bitrate.userService.controller;


import com.bitrate.userService.constants.UserConstants;
import com.bitrate.userService.dto.JwtResponseDto;
import com.bitrate.userService.dto.ResponseDto;
import com.bitrate.userService.dto.UserDto;
import com.bitrate.userService.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth", produces = {"application/json"})
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final IUserService iUserService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signup (@RequestBody @Valid UserDto userDto) {
        iUserService.create(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponseDto> signin (@RequestBody @Valid UserDto userDto) {
        JwtResponseDto jwtResponseDto = iUserService
                .signin(userDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jwtResponseDto);
    }

}

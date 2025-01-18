package com.bitrate.userService.service;

import com.bitrate.userService.dto.JwtResponseDto;
import com.bitrate.userService.dto.UserDto;

public interface IUserService {

    void create(UserDto userDto);

    JwtResponseDto signin (UserDto userDto);

    boolean validateToken(String token);

}

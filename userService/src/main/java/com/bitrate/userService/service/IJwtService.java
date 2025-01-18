package com.bitrate.userService.service;

public interface IJwtService {

    boolean validateToken(String token);

    String generateToken(String email);

}

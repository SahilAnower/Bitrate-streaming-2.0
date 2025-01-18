package com.bitrate.userService.service.impl;

import com.bitrate.userService.dto.JwtResponseDto;
import com.bitrate.userService.dto.UserDto;
import com.bitrate.userService.mapper.GenericMapper;
import com.bitrate.userService.repository.UserRepository;
import com.bitrate.userService.service.IJwtService;
import com.bitrate.userService.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService iJwtService;
    private final GenericMapper genericMapper;
    private final AuthenticationManager authenticationManager;

    @Override
    public void create(UserDto userDto) {
        userDto.setEncodedPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(
                genericMapper.toUser(userDto)
        );
    }

    private JwtResponseDto generateToken(String email) {
        String token = iJwtService.generateToken(email);
        return JwtResponseDto.builder().accessToken(token).build();
    }

    @Override
    public JwtResponseDto signin (UserDto userDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return generateToken(userDto.getEmail());
        }else {
            throw new RuntimeException("Authentication Unsuccessful!");
        }
    }

    @Override
    public boolean validateToken(String token) {
        return iJwtService.validateToken(token);
    }
}

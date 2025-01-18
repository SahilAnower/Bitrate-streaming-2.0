package com.bitrate.userService.mapper;


import com.bitrate.userService.dto.UserDto;
import com.bitrate.userService.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface GenericMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

}

package com.demo.springsecurityblogappmuhammedduzgun.mapper;

import com.demo.springsecurityblogappmuhammedduzgun.dto.UserDto;
import com.demo.springsecurityblogappmuhammedduzgun.entity.User;
import com.demo.springsecurityblogappmuhammedduzgun.request.user.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PostMapper postMapper;

    public UserMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    //User -> UserDto
    public UserDto maptoUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPostList(user.getPosts().stream().map(postMapper::mapToPostResponse).toList());
        return userDto;
    }

    //CreateUserRequest -> User
    public User maptoUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword()); //fixme : cryption ?
        return user;
    }

}

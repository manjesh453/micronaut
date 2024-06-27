package com.estore.users;

import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @Post("/create_user")
    public String createUser(@Body UserDto userDto){
        return service.createUser(userDto);
    }

    @Post("/update_user/{userId}")
    public String updateUser(@Body UserDto userDto,@PathVariable Integer userId){
        return service.updateUser(userDto,userId);
    }

    @Get("/get_user_by_id/{userId}")
    public UserDto getUserById(@PathVariable Integer userId){
        return service.getUser(userId);
    }

    @Get("/get_all_users")
    public List<UserDto> getAllusers() {
        return service.getAllUsers();
    }
}

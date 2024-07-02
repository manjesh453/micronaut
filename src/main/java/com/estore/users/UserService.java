package com.estore.users;

import java.util.List;

public interface UserService {
    String createUser(UserDto request);
    UserDto getUser(int userId);
    String updateUser(UserDto request,Integer userId);
    List<User> getAllUsers();
}

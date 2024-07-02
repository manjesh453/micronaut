package com.estore.users;

import com.estore.shared.Roles;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo repo;

    @Override
    public String createUser(UserDto request) {
        User userEntity = modelMapper.map(request, User.class);
        userEntity.setRole(Roles.CUSTOMER);
        repo.save(userEntity);
        return "User created successfully";
    }

    @Override
    public UserDto getUser(int userId) {
        User userEntity = repo.findById(userId).block();
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public String updateUser(UserDto request, Integer userId) {
        User userEntity = repo.findById(userId).block();
        userEntity.setUsername(request.name());
        userEntity.setEmail(request.email());
        userEntity.setContact(request.contact());
        userEntity.setPassword(request.password());
        repo.save(userEntity);
        return "User updated successfully";
    }


    @Override
    public List<User> getAllUsers() {
        return repo.findAll().collectList().block();
    }
}

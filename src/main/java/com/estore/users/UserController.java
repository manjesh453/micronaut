package com.estore.users;

import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @Post("/create_user")
    @Operation(summary = "Create a user", description = "Creates a new user", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User details", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))), responses = {@ApiResponse(responseCode = "200", description = "User created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))), @ApiResponse(responseCode = "400", description = "Invalid input")})
    public String createUser(@Body UserDto userDto) {
        return service.createUser(userDto);
    }

    @Post("/update_user/{userId}")
    @Operation(summary = "Update a user", description = "Updates an existing user", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Updated user details", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))), responses = {@ApiResponse(responseCode = "200", description = "User updated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))), @ApiResponse(responseCode = "404", description = "User not found")})
    public String updateUser(@Body UserDto userDto, @PathVariable Integer userId) {
        return service.updateUser(userDto, userId);
    }

    @Get("/get_user_by_id/{userId}")
    @Operation(summary = "Get user by ID", description = "Returns a user by ID", responses = {@ApiResponse(responseCode = "200", description = "User details", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))), @ApiResponse(responseCode = "404", description = "User not found")})
    public UserDto getUserById(@PathVariable Integer userId) {
        return service.getUser(userId);
    }

    @Get("/get_all_users")
    @Operation(summary = "Get all users", description = "Returns a list of all users", responses = {@ApiResponse(responseCode = "200", description = "List of users", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class)))})
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}

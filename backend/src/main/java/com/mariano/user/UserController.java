package com.mariano.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public UserDTO getUser(
        @PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(
        @PathVariable("userId") Integer userId) {
        userService.deleteUserById(userId);
        }
    
    
    @PutMapping("{userId}")
    public void updateUser(
            @PathVariable("userId") Integer userId,
            @RequestBody UserUpdateRequest updateRequest) {
        userService.updateUser(userId, updateRequest);
    }
}

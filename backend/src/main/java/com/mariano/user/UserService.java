package com.mariano.user;

import java.util.List;
import java.util.stream.Collectors;

import com.mariano.exception.DuplicateResourceException;
import com.mariano.exception.RequestValidationException;
import com.mariano.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final UserDTOMapper userDTOMapper;

    public UserService(@Qualifier("jpa") UserDAO userDAO,
                        UserDTOMapper userDTOMapper) {
        this.userDAO = userDAO;
        this.userDTOMapper = userDTOMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.selectAllUsers()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(Integer id) {
    return userDAO.selectUserById(id)
            .map(userDTOMapper)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "user with id [%s] not found".formatted(id)
            ));
    }

    public void deleteUserById(Integer userId) {
        if (!userDAO.existsUserById(userId)) {
            throw new ResourceNotFoundException(
                    "User with id [%s] not found".formatted(userId)
            );
        }

        userDAO.deleteUserById(userId);
    }


    public void updateUser(Integer userId, 
                            UserUpdateRequest userUpdateRequest) {
        User user = userDAO.selectUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "user with id [%s] not found".formatted(userId)
                ));
        
        boolean flag = false;

        if (userUpdateRequest.name() != null && !userUpdateRequest.name().equals(user.getName())) {
            user.setName(userUpdateRequest.name());
            flag = true;
        }

        if (userUpdateRequest.age() != null && !userUpdateRequest.age().equals(user.getAge())) {
            user.setAge(userUpdateRequest.age());
            flag = true;
        }

        if (userUpdateRequest.email() != null && !userUpdateRequest.email().equals(user.getEmail())) {
            if (userDAO.existsUserWithEmail(userUpdateRequest.email())) {
                throw new DuplicateResourceException(
            "email already taken"
            );
            }

            user.setEmail(userUpdateRequest.email());
            flag = true;
        }

        if (!flag) {
            throw new RequestValidationException("no data changes found");
        }

        userDAO.updateUser(user);

    }
}

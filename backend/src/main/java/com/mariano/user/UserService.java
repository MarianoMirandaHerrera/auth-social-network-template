package com.mariano.user;

import java.util.List;
import java.util.stream.Collectors;

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
}

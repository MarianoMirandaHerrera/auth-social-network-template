package com.mariano.user;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> selectAllUsers();
    Optional<User> selectUserById(Integer id);
    boolean existsUserById(Integer userId);
    boolean existsUserWithEmail(String email);
    void deleteUserById(Integer userId);
    void updateUser(User user);

}

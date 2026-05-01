package com.mariano.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository("jdbc")
public class UserJDBCDataAccessService implements UserDAO {

    @Override
    public List<User> selectAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAllUsers'");
    }

    @Override
    public Optional<User> selectUserById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectUserById'");
    }

    @Override
    public boolean existsUserById(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsUserById'");
    }

    @Override
    public void deleteUserById(Integer userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existUserWithEmail'");
    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }
 
}

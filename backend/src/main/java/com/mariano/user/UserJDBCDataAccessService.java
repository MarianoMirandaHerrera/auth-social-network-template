package com.mariano.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("jdbc")
public class UserJDBCDataAccessService implements UserDAO {

    @Override
    public List<User> selectAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAllUsers'");
    }
 
}

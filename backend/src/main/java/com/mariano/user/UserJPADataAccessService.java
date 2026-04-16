package com.mariano.user;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository("jpa")
public class UserJPADataAccessService implements UserDAO {

    private final UserRepository userRepository;

    public UserJPADataAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> selectAllUsers() {
        Page<User> page = userRepository.findAll(Pageable.ofSize(1000));
        return page.getContent();
    }
}

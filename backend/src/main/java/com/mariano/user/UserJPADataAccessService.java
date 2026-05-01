package com.mariano.user;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<User> selectUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsUserById(Integer userId) {
        return userRepository.existsUserById(userId);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public void updateUser(User update) {
        userRepository.save(update);
    }

    
}

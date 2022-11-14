package edu.miu.userservice.service.impl;

import edu.miu.userservice.entity.User;
import edu.miu.userservice.repository.UserRepository;
import edu.miu.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: Kuylim TITH
 * Date: 11/13/2022
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }
}

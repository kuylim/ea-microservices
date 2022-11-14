package edu.miu.userservice.service;

import edu.miu.userservice.entity.User;

/**
 * Author: Kuylim TITH
 * Date: 11/13/2022
 */
public interface UserService {

    User findUserById(Long id);
}

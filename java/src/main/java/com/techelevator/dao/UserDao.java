package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(Long userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(Long familyId, boolean is_parent, String firstName,
                   String lastName, String email, String username, String password, String role);
}

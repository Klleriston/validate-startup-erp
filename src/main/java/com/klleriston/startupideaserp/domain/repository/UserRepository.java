package com.klleriston.startupideaserp.domain.repository;


import com.klleriston.startupideaserp.domain.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(String id);
    List<User> findAll();
    User update(User user);
    void delete(String id);
}

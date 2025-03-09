package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.User;
import com.klleriston.startupideaserp.infra.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCase {
    private final UserRepositoryImpl userRepositoryImpl;

    @Autowired
    public UserUseCase(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public User save(User user) {
        return userRepositoryImpl.save(user);
    }

    public List<User> listAllUsers() {
        return userRepositoryImpl.findAll();
    }

    public User update(User user) {
       User existingUser = userRepositoryImpl.findById(user.getId()).orElseThrow(() -> new IllegalStateException("User with id " + user.getId() + " not found"));

       existingUser.setName(user.getName());
       existingUser.setEmail(user.getEmail());
       existingUser.setRole(user.getRole());
       existingUser.setIdeasIds(user.getIdeasIds());
       existingUser.setCollaborationsIds(user.getCollaborationsIds());

       return userRepositoryImpl.save(existingUser);

    }

    public void delete(String id) {
        userRepositoryImpl.deleteById(id);
    }
}

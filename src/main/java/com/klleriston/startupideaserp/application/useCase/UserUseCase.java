package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.domain.model.User;
import com.klleriston.startupideaserp.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserUseCase {
    private final UserRepository userRepository;

    @Autowired
    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    public User update(User user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalStateException("User with id " + user.getId() + " not found"));

        if (!existingUser.getEmail().equals(user.getEmail()) &&
                userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setIdeasIds(user.getIdeasIds());
        existingUser.setCollaborationsIds(user.getCollaborationsIds());

        return userRepository.save(existingUser);
    }


    public void delete(String id) {
        userRepository.deleteById(id);
    }
}

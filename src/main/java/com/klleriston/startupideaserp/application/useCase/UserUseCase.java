package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {
    private final UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}

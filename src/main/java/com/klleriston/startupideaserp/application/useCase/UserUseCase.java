package com.klleriston.startupideaserp.application.useCase;

import com.klleriston.startupideaserp.infra.repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {
    private final UserRepositoryImpl userRepositoryImpl;

    public UserUseCase(UserRepositoryImpl userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }


}

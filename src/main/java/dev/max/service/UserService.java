package dev.max.service;

import dev.max.dto.User;

public interface UserService {
    void saveUser(String username, String password);
    User getByUsername(String username);
}

package com.smart.app.weighing.auth.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
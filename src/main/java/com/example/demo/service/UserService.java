package com.example.demo.service;


public interface UserService {
    String getUserById(String userId);

    String testRedisSet(String userId);

    String testRedisTemplateAdd(String userId);

    String testZAdd(String userId);

    String testZReverseRange(String userId);
}

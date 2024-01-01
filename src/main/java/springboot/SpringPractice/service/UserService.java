package springboot.SpringPractice.service;

import springboot.SpringPractice.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    UserEntity findById(long pid);
    UserEntity save(UserEntity user);
    void deleteById(long pid);
}

package springboot.SpringPractice.service;

import springboot.SpringPractice.VO.UserVO;
import springboot.SpringPractice.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAll();
    UserEntity findById(long pid);
    UserEntity save(UserVO user);
    void deleteById(long pid);
    boolean signin(UserEntity user);
}

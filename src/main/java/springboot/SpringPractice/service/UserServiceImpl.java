package springboot.SpringPractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.SpringPractice.DAO.UserRepository;
import springboot.SpringPractice.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(long pid) {
        Optional<UserEntity> result = userRepository.findById(pid);
        UserEntity userEntity = null;
        if (result.isPresent()) {
            userEntity = result.get();
        } else {
            throw new RuntimeException("Did not find user id : " + pid);
        }
        return null;
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long pid) {
        userRepository.deleteById(pid);
    }

    @Override
    public String signin(UserEntity user) {
        List<UserEntity> result = userRepository.findByEmail(user.getEmail());
        if (result.isEmpty()){
            return "no result";
        }
        else {
            UserEntity userEntity = result.get(0);
            return userEntity.toString();
        }
    }
}

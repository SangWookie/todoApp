package springboot.SpringPractice.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.SpringPractice.DAO.UserRepository;
import springboot.SpringPractice.DTO.TodoDTO;
import springboot.SpringPractice.VO.UserVO;
import springboot.SpringPractice.entity.Role;
import springboot.SpringPractice.entity.TodoEntity;
import springboot.SpringPractice.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final TodoService todoService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TodoService todoService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.todoService = todoService;
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
    public UserEntity save(UserVO user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return null;
        }

        UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .password(bCryptPasswordEncoder.encode(user.getPassword()))
                .role(Role.USER.getValue())
                .build();
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteById(long pid) {
        userRepository.deleteById(pid);
    }

    @Override
    public boolean signin(UserEntity user) {
        UserEntity result = userRepository.findByEmail(user.getEmail());
        if (result == null) {
            return false;
        } else {
            if (result.getPassword().equals(user.getPassword()))
                return true;
            else return false;
        }
    }

    public TodoEntity saveTodo(TodoDTO todoDTO) {

        UserEntity user = userRepository.findByEmail(todoDTO.getAuthorEmail());

        if (user == null)
            return null;

        TodoEntity todo = TodoEntity.builder()
                .title(todoDTO.getTitle())
                .detail(todoDTO.getDetail())
                .isDone(false)
                .author(user)
                .build();

        todoService.save(todo);
        return todo;
    }

    public List<TodoDTO> findTodoByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null)
            throw new EntityNotFoundException("Entity not found with email : " + email);

        List<TodoEntity> todoList = user.getTodoEntityList();
        if (todoList.isEmpty())
            throw new RuntimeException("No todos found with email : " + email);

        List<TodoDTO> todoDTOS = new ArrayList<>();
        for (TodoEntity todoEntity : todoList) {
            TodoDTO todoDTO = todoEntity.toTodoDTO();
            todoDTOS.add(todoDTO);
        }
        return todoDTOS;
    }
}

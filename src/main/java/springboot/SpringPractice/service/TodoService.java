package springboot.SpringPractice.service;

import org.springframework.stereotype.Service;
import springboot.SpringPractice.DAO.TodoRepository;
import springboot.SpringPractice.entity.TodoEntity;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public TodoEntity save(TodoEntity todoEntity){
        todoRepository.save(todoEntity);
        return todoEntity;
    }

}

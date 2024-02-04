package springboot.SpringPractice.DTO;

import lombok.*;
import springboot.SpringPractice.entity.TodoEntity;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    Long id;
    String title;
    String detail;
    String authorEmail;
    Boolean isDone;
}

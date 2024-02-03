package springboot.SpringPractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.SpringPractice.DTO.TodoDTO;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "detail")
    private String detail;

    @Column(name = "is_done")
    private boolean isDone;

    @ManyToOne
    @JoinColumn(name = "pid")
    private UserEntity author;

    public TodoDTO toTodoDTO() {
        return TodoDTO.builder()
                .title(this.title)
                .detail(this.detail)
                .isDone(this.isDone)
                .build();
    }
}

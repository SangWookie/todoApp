package springboot.SpringPractice.VO;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserVO {
    private String email;
    private String password;
}

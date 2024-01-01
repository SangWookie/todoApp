package springboot.SpringPractice.DTO;

import springboot.SpringPractice.entity.UserEntity;

public class UserDTO {
    String email;
    public UserDTO(UserEntity userEntity){
        this.email = userEntity.getEmail();
    }
}

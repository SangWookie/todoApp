package springboot.SpringPractice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class UserRefreshToken {
    @Id
    private long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "email")
    private UserEntity userEntity;

    private String refreshToken;

    public UserRefreshToken(UserEntity userEntity, String refreshToken){
        this.userId = userEntity.getPid();
        this.userEntity = userEntity;
        this.refreshToken = refreshToken;
    }
    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
    public boolean validateRefreshToken(String refreshToken){
        return this.refreshToken.equals(refreshToken);
    }
}

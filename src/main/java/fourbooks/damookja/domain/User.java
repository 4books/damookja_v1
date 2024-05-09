package fourbooks.damookja.domain;

import fourbooks.damookja.domain.enums.Active;
import fourbooks.damookja.domain.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    @NotEmpty(message = "이름은 필수예요.")
    private String name;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "비밀번호는 필수예요.")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty(message = "이메일은 필수예요.")
    @Email(message = "이메일을 올바르게 작성해 주세요.")
    private String email;

    @Column(name = "login_try_count", columnDefinition = "INT DEFAULT 0")
    private Integer loginTryCount = 0;

    @Column(name = "is_active")
    private Active isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    public Integer plusLoginTryCount(){
        this.loginTryCount++;
        return this.loginTryCount;
    }
    public void clearLoginTryCount(){
        this.loginTryCount = 0;
    }
    public void lockUser(){
        this.isActive = Active.LOCK;
    }
    public void inActiveUser(){
        this.isActive = Active.NO;
    }
    public void initUser(){
        this.isActive = Active.INIT;
    }
    public void activeUser(){
        this.isActive = Active.YES;
    }
}

package fourbooks.damookja.domain;

import fourbooks.damookja.domain.enums.UserActive;
import fourbooks.damookja.domain.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
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

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "이메일은 필수예요.")
    @Email(message = "이메일을 올바르게 작성해 주세요.")
    private String email;

    @Column(name = "login_attempts", columnDefinition = "INT DEFAULT 0")
    private Integer loginAttempts = 0;

    @Column(name = "is_active")
    private UserActive isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserType userType;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}

package fourbooks.damookja.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fridges")
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Fridge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fridge_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "fridge_name", nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_fridges_users")
    )
    private User user;

    @Column(name = "description")
    private String description;
}

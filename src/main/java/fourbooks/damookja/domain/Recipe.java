package fourbooks.damookja.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "recipe")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    private int stockCount;
    private Long price;

    @Column(name = "created_time")
    private LocalDateTime createdAt;
}

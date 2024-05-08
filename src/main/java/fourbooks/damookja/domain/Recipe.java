package fourbooks.damookja.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    private int stockCount;
    private Long price;

    @Column(name = "created_time")
    private LocalDateTime createdAt;
}

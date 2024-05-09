package fourbooks.damookja.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingredients")
@Getter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredients_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "ingredients_name", nullable = false)
    private String name;

    @Column(name = "type")
    private String type;
}

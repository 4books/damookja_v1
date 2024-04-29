package fourbooks.damookja.domain.exhandler;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ErrorResult {
    private String code;
    private String message;
}

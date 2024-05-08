package fourbooks.damookja.infrastructure.web.exceptionhandler;

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

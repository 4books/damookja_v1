package fourbooks.damookja.domain.exception;

public class RecipeNotFoundException extends ItemNotFoundException {
    public RecipeNotFoundException() {
        super();
    }

    public RecipeNotFoundException(String message) {
        super(message);
    }

    public RecipeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipeNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RecipeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

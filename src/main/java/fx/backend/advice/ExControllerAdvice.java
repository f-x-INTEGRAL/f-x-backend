package fx.backend.advice;

import fx.backend.form.FormController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.LimitExceededException;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return ResponseEntity.status(409).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> NoSuchElementHandler(NoSuchElementException e) {
        log.info("[exceptionHandler] ex");

        return ResponseEntity.status(404).body(e.getMessage());
    }
    @ExceptionHandler(LimitExceededException.class)
    public ResponseEntity<String> limitExceededHandler(LimitExceededException e) {
        log.error("[exceptionHandler] ex", e);

        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

package fx.backend.advice;

import fx.backend.form.FormController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackageClasses = FormController.class)
public class ExControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalExHandler(IllegalArgumentException e) {
        log.error("[exceptionHandler] ex", e);
        return ResponseEntity.status(409).body(e.getMessage());
    }

}
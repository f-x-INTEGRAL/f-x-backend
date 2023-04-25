package fx.backend.home;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomeController {
    @GetMapping("/")
    public void redirectToExternalUrl(HttpServletResponse response) throws IOException {
        String externalUrl = "https://nabom.live";
        response.sendRedirect(externalUrl);
    }
}

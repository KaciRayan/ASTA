package efrei.lequipe.ASTA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ASTA_Application {

    public static void main(String[] args) {
        SpringApplication.run(ASTA_Application.class, args);
    }

    @GetMapping
    public String getHello() {
        return "Go to http://localhost:8080/swagger-ui/index.html#/ to see available actions";
    }

}

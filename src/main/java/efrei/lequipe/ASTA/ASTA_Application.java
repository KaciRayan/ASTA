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
        var swaggerLink = "./swagger-ui/index.html#/"; // lien : http://localhost:8080/asta/v1/swagger-io/index.html#/
        return "Go to <a href=" + swaggerLink+ ">OpenAI Swagger</a> to see available actions";
    }

}

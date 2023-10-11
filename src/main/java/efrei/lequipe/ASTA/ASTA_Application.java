package efrei.lequipe.ASTA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class ASTA_Application {

    public static void main(String[] args) {
        SpringApplication.run(ASTA_Application.class, args);
    }

    @GetMapping
    public List<String> getHello() {
        return List.of("Hello World", "Hello Might");
    }

}

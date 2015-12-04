package ua.kiev.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@PropertySource({"resources/META-INF/application.properties"})*/
@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}

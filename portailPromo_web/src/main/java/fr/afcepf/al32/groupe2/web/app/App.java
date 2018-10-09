package fr.afcepf.al32.groupe2.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages="fr.afcepf.al32.groupe2")
@EntityScan(basePackages="fr.afcepf.al32.groupe2.entity")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

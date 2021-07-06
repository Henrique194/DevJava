package mjv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication { //the @SpringBootApplication annotation which implicitly includes @ComponentScan

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}

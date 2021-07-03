package mjv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import mjv.model.CadastroRepository;

import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class SpringProjectApplication { //the @SpringBootApplication annotation which implicitly includes @ComponentScan

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}

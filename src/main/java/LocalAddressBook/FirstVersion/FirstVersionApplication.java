package LocalAddressBook.FirstVersion;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstVersionApplication {
	public static List pathList;

	public static void main(String[] args) {
		SpringApplication.run(FirstVersionApplication.class, args);
	}

}

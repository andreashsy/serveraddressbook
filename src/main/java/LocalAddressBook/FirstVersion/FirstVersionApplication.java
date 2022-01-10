package LocalAddressBook.FirstVersion;

import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FirstVersionApplication {
	private static final Logger logger = LoggerFactory.getLogger(FirstVersionApplication.class);
	public static List pathList;

	public static void main(String[] args) {
		SpringApplication.run(FirstVersionApplication.class, args);

		// check if command line argument is run
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		pathList = appArgs.getOptionValues("dataDir");
		if (pathList == null) {
			System.out.println("Please specify a directory with --dataDir=<directory path> option!");
			System.exit(1);
		}

	}

}

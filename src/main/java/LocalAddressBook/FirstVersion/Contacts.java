package LocalAddressBook.FirstVersion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.ui.Model;

public class Contacts {
    Logger logger = LoggerFactory.getLogger(Contacts.class);
    private String path = "";
    private Model model;
    private Contact contact;
    private ApplicationArguments applicationArguments;

    public Contacts() {

    }

    public Contacts(ApplicationArguments applicationArguments, Model model, Contact contact) {
        this.applicationArguments = applicationArguments;
        this.model = model;
        this.contact = contact;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return this.path;
    }

    public void saveFile(ApplicationArguments applicationArguments, Model model, Contact contact) {
        //generate hexadecimal id number
        Random rng = new Random();
        int firstSerialNumber = rng.nextInt(65535);
        int secondSerialNumber = rng.nextInt(65535);
        String id = Integer.toHexString(firstSerialNumber) + Integer.toHexString(secondSerialNumber);
        logger.info("ID is: " + id);
        
        // loads the path
        List pathList = applicationArguments.getOptionValues("dataDir");
        String pathStr = (String) pathList.get(0);
		logger.info("Path is : " + pathStr);
        String idPath = pathStr + "/" + id + "/" + this.path;
		Path path = Paths.get(idPath);

        // make directory if it does not exist
        if (!Files.isDirectory(path)) {
			new File(idPath).mkdirs();
			logger.info("Path does not exist, created " + idPath);
		} else {
			logger.info("Path " + idPath + " exists!");
		}
        try {
            String fileName = idPath + "/" + id + ".txt";
            logger.info("fileName is: " + fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(contact.getName());
            writer.newLine();
            writer.write(contact.getEmailAddress());
            writer.newLine();
            writer.write(contact.getContactNumber());
            writer.close();           
        } catch (Exception e) {
            logger.info("Exception: " + e);
        }
        
    }

    public void loadFile(ApplicationArguments applicationArguments, Model model, String id) {
        // loads the path
        List pathList = applicationArguments.getOptionValues("dataDir");
        String pathStr = (String) pathList.get(0);
        logger.info("Path is : " + pathStr);
        String idPath = pathStr + "/" + id + "/" + this.path;
        Path path = Paths.get(idPath);

        // check if id exists
        if (!Files.isDirectory(path)) {
			logger.info("Path does not exist: " + idPath);
            System.exit(1);
		} else {
			logger.info("Path " + idPath + " exists!");
        }

        Contact cn = new Contact();

        //read file
        String fileName = idPath + "/" + id + ".txt";
        try {
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
            
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                logger.info(everything);
                String[] contactData = everything.split(System.lineSeparator());
                cn.setName(contactData[0]);
                cn.setEmailAddress(contactData[1]);
                cn.setContactNumber(contactData[2]);
                model.addAttribute("contact", cn);

            }
        } catch (Exception e) {
            logger.info("Error, exception");
        }
}
}

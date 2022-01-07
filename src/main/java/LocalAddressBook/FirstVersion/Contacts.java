package LocalAddressBook.FirstVersion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Contacts {
    Logger logger = LoggerFactory.getLogger(Contacts.class);
    private String path = "";

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return this.path;
    }

    public void saveFile(String id, String info) {
        String idPath = id + "//" + this.path;
        Path path = Paths.get(idPath);
        if (!Files.isDirectory(path)) {
			new File(idPath).mkdirs();
			logger.info("Path does not exist, created " + idPath);
		} else {
			logger.info("Path " + idPath + " exists!");
		}
        try {
        OutputStream os = new FileOutputStream(idPath + "//" + id + ".txt");
        byte[] strToByte = info.getBytes();
        os.write(strToByte); 
        os.close();     
        } catch (Exception e) {
            logger.info("Exception: " + e);
        }
        
    }

    public void readFile(String id) {
        
    }
}

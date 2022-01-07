package LocalAddressBook.FirstVersion;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ContactController {
    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/")
    public String showContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contactObj", contact);
        return "form";
    }

    @PostMapping("/contact")
    public String saveContact(@ModelAttribute Contact contact, Model model) {
        logger.info("Received from the form: " + contact.getName());
        logger.info("Received from the form: " + contact.getEmailAddress());
        logger.info("Received from the form: " + contact.getContactNumber());

        //generate hexadecimal id number
        Random rng = new Random();
        int firstSerialNumber = rng.nextInt(65535);
        int secondSerialNumber = rng.nextInt(65535);
        String id = Integer.toHexString(firstSerialNumber) + Integer.toHexString(secondSerialNumber);
        logger.info("ID is: " + id);

        //save contact information to file
        
        


        return "result";
    }
    

}

package LocalAddressBook.FirstVersion.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import LocalAddressBook.FirstVersion.ContactsRedis;
import LocalAddressBook.FirstVersion.model.Contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ContactController {
    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactsRedis ctc;

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

        //save contact information to file
        ContactsRedis ctc = new ContactsRedis();
        String data = ctc.toConcatList(contact);
        ctc.save(data);
        return "result";
    }
    
    @GetMapping("/users/{id}")
    public String getContact(@PathVariable String id, Model model) {
        logger.info("Contact id is: " + id);
        ContactsRedis ctc = new ContactsRedis();
        String dataStr = ctc.findById(id);
        String[] data = dataStr.split(",,,,,");
        Contact contact = new Contact();
        contact.setName(data[0]);
        contact.setContactNumber(data[1]);
        contact.setEmailAddress(data[2]);
        model.addAttribute("contact", contact);
        return "showcontact";
    }
}

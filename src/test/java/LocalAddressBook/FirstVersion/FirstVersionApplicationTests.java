package LocalAddressBook.FirstVersion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;

import LocalAddressBook.FirstVersion.model.Contact;

@SpringBootTest
class FirstVersionApplicationTests {

	@Autowired
    ApplicationArguments applicationArguments;

	@Test
	void contextLoads() {
	}
/*
	@Test
	public void testSave() {
		Contacts contacts = new Contacts();
		Contact contact = new Contact();
		contact.setContactNumber("1234");
		contact.setEmailAddress("testemail");
		contact.setName("testname");
		contacts.saveFile(applicationArguments, contact);
	}
*/
}

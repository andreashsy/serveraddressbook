package LocalAddressBook.FirstVersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import LocalAddressBook.FirstVersion.model.Contact;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ContactsRedis implements ContactsRepo{
    private final String CONTACT_CACHE = "CONTACT";
    Logger logger = LoggerFactory.getLogger(ContactsRedis.class);
    private final String DELIM = ",,,,,";

    @Autowired
    @Qualifier("mainBean")
    RedisTemplate<String, Object> template;

    @Override 
    public void save(final Object contact) { 
        //generate hexadecimal id number
        Random rng = new Random();
        int firstSerialNumber = rng.nextInt(65535);
        int secondSerialNumber = rng.nextInt(65535);
        String id = Integer.toHexString(firstSerialNumber) + Integer.toHexString(secondSerialNumber);
        logger.info("ID is: " + id);

        template.opsForValue().set(id, contact);
    }

    @Override 
    public Contact findById(String id) {
        return (Contact)template.opsForValue().get(id);
    }

    @Override 
    public List<Object> findAll() {
        return template.opsForList().range(CONTACT_CACHE, 0, -1);
    }

    @Override 
    public void delete(String id) {
        template.delete(id);
    }

}

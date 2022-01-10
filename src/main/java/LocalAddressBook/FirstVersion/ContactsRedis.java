package LocalAddressBook.FirstVersion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import LocalAddressBook.FirstVersion.model.Contact;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ContactsRedis implements ContactsRepo{
    Logger logger = LoggerFactory.getLogger(ContactsRedis.class);
    private final String CONTENT_CACHE = "CONTACT";

    @Autowired
    private RedisTemplate<String, Contact> template;

    @Override 
    public void save(final Contact ctc) {
        template.opsForValue().set(ctc.getId(), ctc);
    }

    @Override 
    public Contact findById(final String id) {
        return (Contact)template.opsForValue().get(id);
    }

    @Override 
    public List<Contact> findAll() {
        return template.opsForList().range(CONTENT_CACHE, 0, -1);
    }

    @Override 
    public void delete(final String id) {
        template.delete(id);
    }

}

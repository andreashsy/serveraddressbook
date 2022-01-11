package LocalAddressBook.FirstVersion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import LocalAddressBook.FirstVersion.model.Contact;

@Repository
public interface ContactsRepo {
    public void save(final Object contact);
    public Contact findById(final String id);
    public List<Object> findAll();
    public void delete(String id);
    
}

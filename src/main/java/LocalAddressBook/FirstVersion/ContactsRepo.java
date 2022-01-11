package LocalAddressBook.FirstVersion;

import java.util.List;

import org.springframework.stereotype.Repository;

import LocalAddressBook.FirstVersion.model.Contact;

@Repository
public interface ContactsRepo {
    public void save(final Object contact);
    public Contact findById(final String id);
    public List<Object> findAll();
    public void delete(String id);
    
}

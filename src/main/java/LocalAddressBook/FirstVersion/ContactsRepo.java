package LocalAddressBook.FirstVersion;

import java.util.List;

import org.springframework.stereotype.Repository;

import LocalAddressBook.FirstVersion.model.Contact;

@Repository
public interface ContactsRepo {
    public void save(final String data);
    public String findById(final String id);
    public List<String> findAll();
    public void delete(String id);
    public String toConcatList(final Contact ctc);
        
}

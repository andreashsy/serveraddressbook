package LocalAddressBook.FirstVersion.model;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name;
    private String contactNumber;
    private String emailAddress;
    private String id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
     public String getEmailAddress() {
         return this.emailAddress;
     }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}

package LocalAddressBook.FirstVersion;

import java.io.Serializable;

public class Contact implements Serializable{
    private String name;
    private String contactNumber;
    private String emailAddress;

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
}

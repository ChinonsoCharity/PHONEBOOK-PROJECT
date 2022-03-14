package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;

public interface ContactRepository {
   public Contact saveContact (Contact theContact);
    int count();
    void deleteContact(Contact theContact);
    Contact findByName(String name);
    Contact findByNumber(String mobile);
}

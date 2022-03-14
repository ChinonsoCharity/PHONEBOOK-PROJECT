package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    List<Contact> db = new ArrayList<>();
    private  int count;

    @Override
    public Contact saveContact(Contact theContact) {
        db.add(theContact);
        count++;

        return theContact;
    }

    @Override
    public int count() {
      return db.size();
        //return count;
    }

    @Override
    public void deleteContact(Contact theContact) {
        db.remove(theContact);
        count--;
    }

    @Override
    public Contact findByName(String name) {
        for (Contact contact :db){
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name))
                return contact;
        }
        return null;
    }

    @Override
    public Contact findByNumber(String mobile) {
        for (Contact contact :db){
            if (contact.getMobile().equals(mobile));
            return contact;
        }
        return null;
    }
}

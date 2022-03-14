package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    ContactRepository contactRepository;
    @BeforeEach
    void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }
    @Test
    public  void  contactCanBeSaveTest(){
        Contact theContact = new Contact();
        theContact.setFirstName("ven");
        theContact.setMiddleName("james");
        theContact.setLastName("adams");
        theContact.setOffice("NNPC");
        theContact.setMobile("23456");
        contactRepository.saveContact(theContact);
        assertEquals(1,contactRepository.count());
    }
    @Test
    public  void contactCanBeDeletedTest(){
        Contact theContact = new Contact();
        theContact.setFirstName("ven");
        theContact.setMiddleName("james");
        theContact.setLastName("adams");
        theContact.setOffice("NNPC");
        theContact.setMobile("23456");
        contactRepository.saveContact(theContact);
        Contact theContact1 = new Contact();
        theContact.setFirstName("vin");
        theContact.setMiddleName("joel");
        theContact.setLastName("joel");
        theContact.setOffice("CBN");
        theContact.setMobile("34567");
        contactRepository.saveContact(theContact1);

        assertEquals(2,contactRepository.count());

        contactRepository.deleteContact(theContact);
        assertEquals(1,contactRepository.count());
    }
    @Test
    public void findByName(){
        Contact theContact = new Contact();
        theContact.setFirstName("ven");
        theContact.setMiddleName("james");
        theContact.setLastName("adams");
        theContact.setOffice("NNPC");
        theContact.setMobile("23456");
        contactRepository.saveContact(theContact);

        Contact theContact1 = new Contact();
        theContact1.setFirstName("vin");
        theContact1.setMiddleName("joel");
        theContact1.setLastName("joel");
        theContact1.setOffice("CBN");
        theContact1.setMobile("34567");
        contactRepository.saveContact(theContact1);

        assertEquals(2,contactRepository.count());

       Contact foundContact = contactRepository.findByName("vin");

        assertEquals(theContact1,foundContact);

    }

}
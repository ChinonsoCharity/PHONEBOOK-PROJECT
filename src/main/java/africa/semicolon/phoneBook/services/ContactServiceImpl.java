package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dto.request.AddContactRequest;
import africa.semicolon.phoneBook.dto.response.ContactResponse;
import africa.semicolon.phoneBook.dto.response.FindContactResponse;
import africa.semicolon.phoneBook.exception.ContactNotFoundException;

public class ContactServiceImpl implements ContactService {
    ContactRepository repository = new ContactRepositoryImpl();
    @Override
    public ContactResponse saveContact(AddContactRequest request) {
        Contact theContact = new Contact();
        theContact.setFirstName(request.getFirstName());
        theContact.setMiddleName(request.getMiddleName());
        theContact.setLastName(request.getLastName());
        theContact.setMobile(request.getMobile());
        theContact.setOffice(request.getOffice());
        repository.saveContact(theContact);

       // Contact newContact = repository.saveContact(theContact);
        ContactResponse response  = new ContactResponse();
        response.setFullName(theContact.getFirstName()+" "+theContact.getMiddleName()+" "+theContact.getLastName());
        response.setMobile(theContact.getMobile());
        response.setMessage("Contact Saved");


        return response;
    }

    @Override
    public ContactRepository getRepository() {
        return repository;
    }

    @Override
    public FindContactResponse findContactByName(String name) {
        name = name.toLowerCase();
        Contact theContact = repository.findByName(name);
        if (theContact == null)throw new ContactNotFoundException(name + " not found");
        FindContactResponse response = new FindContactResponse();
        response.setFirstName(theContact.getFirstName());
        response.setMiddleName(theContact.getMiddleName());
        response.setLastName(theContact.getLastName());
        response.setMobile(theContact.getMobile());
        response.setOffice(theContact.getOffice());
        return response;
    }

    @Override
    public ContactResponse deleteContact(String name, String mobile) {
        Contact theContact = repository.findByName(name);
        if (theContact.getLastName().equalsIgnoreCase(name) && theContact.getMobile().equalsIgnoreCase(mobile))
            repository.deleteContact(theContact);
            ContactResponse response = new ContactResponse();
            response.setMessage("Contact Deleted");
            return response;

    }
}

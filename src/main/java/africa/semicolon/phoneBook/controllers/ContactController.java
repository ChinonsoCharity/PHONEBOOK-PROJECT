package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.dto.request.AddContactRequest;
import africa.semicolon.phoneBook.dto.response.ContactResponse;
import africa.semicolon.phoneBook.dto.response.FindContactResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private ContactService theContactService = new ContactServiceImpl();
    @PostMapping("/save")
   public ContactResponse saveContact(@RequestBody AddContactRequest request){
       return theContactService.saveContact(request);
   }
    @GetMapping("/(search)")
   public FindContactResponse findContactByName(@PathVariable String name){
       return theContactService.findContactByName(name);
   }
    @DeleteMapping("/delete")
   public ContactResponse deleteContact( @PathVariable String name, String mobile){
       return theContactService.deleteContact(name,mobile);
   }

}

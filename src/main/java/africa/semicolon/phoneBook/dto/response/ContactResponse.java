package africa.semicolon.phoneBook.dto.response;

import lombok.Data;

@Data
public class ContactResponse {
    private String fullName;
    private String mobile;
    private String message;
}

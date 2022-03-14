package africa.semicolon.phoneBook.dto.response;

import lombok.Data;

@Data
public class FindContactResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String office;

}

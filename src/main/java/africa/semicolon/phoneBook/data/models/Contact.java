package africa.semicolon.phoneBook.data.models;

import lombok.*;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@NonNull
public class Contact {

    private String firstName;

    private String lastName;

    private String middleName;

    private String mobile;

    private String office;

    public Contact(String name, String mobile) {
    lastName  = name;
    this.mobile = mobile;

    }
}

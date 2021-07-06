package spring.web.dto.request;

import javax.validation.constraints.Size;
import lombok.Data;
import spring.web.lib.validation.FieldsValueMatch;
import spring.web.lib.validation.ValidEmail;

@Data
@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords don't match!"
)
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 8, max = 40)
    private String password;
    private String repeatPassword;
}

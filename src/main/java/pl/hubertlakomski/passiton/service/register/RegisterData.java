package pl.hubertlakomski.passiton.service.register;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class RegisterData {

    @Email
    private String email;
    private String password;
    private String password2;

}

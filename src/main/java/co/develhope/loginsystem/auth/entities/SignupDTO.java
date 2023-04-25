package co.develhope.loginsystem.auth.entities;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SignupDTO {

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;


}

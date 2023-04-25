package co.develhope.loginsystem.auth.entities;

import co.develhope.loginsystem.users.entities.User;
import lombok.Data;

@Data
public class LoginRTO {

    private User user;
    private String jwt;
}

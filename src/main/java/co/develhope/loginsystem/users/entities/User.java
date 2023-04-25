package co.develhope.loginsystem.users.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    private LocalDateTime jwtCreatedOn;
    private boolean isActive;
    @Column(length = 36)
    private String activationCode;


}

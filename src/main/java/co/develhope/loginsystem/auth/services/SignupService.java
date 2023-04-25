package co.develhope.loginsystem.auth.services;

import co.develhope.loginsystem.auth.entities.SignupActivationDTO;
import co.develhope.loginsystem.auth.entities.SignupDTO;
import co.develhope.loginsystem.notifications.services.MailNotificationService;
import co.develhope.loginsystem.users.entities.User;
import co.develhope.loginsystem.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailNotificationService mailNotificationService;

    public User signup(SignupDTO signupDTO){
        User user = new User();
        user.setName(signupDTO.getName());
        user.setSurname(signupDTO.getSurname());
        user.setEmail(signupDTO.getEmail());
        user.setActive(false);
        user.setActivationCode(UUID.randomUUID().toString());

        mailNotificationService.sendActivationMail(user);
        return userRepository.save(user);


    }

    public User activate(SignupActivationDTO signupActivationDTO) throws Exception {
        User user = userRepository.findByActivationCode(signupActivationDTO.getActivationCode());
        if(user == null) throw new Exception("User not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);

    }
}

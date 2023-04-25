package co.develhope.loginsystem.auth.controllers;

import co.develhope.loginsystem.auth.entities.SignupActivationDTO;
import co.develhope.loginsystem.auth.entities.SignupDTO;
import co.develhope.loginsystem.auth.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDTO signupDTO){
        signupService.signup(signupDTO);

    }

    @PostMapping("/signup/activation")
    public void signup(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        signupService.activate(signupActivationDTO);

    }


}

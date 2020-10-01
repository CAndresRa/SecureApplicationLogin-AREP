package edu.escuelaing.arep.centificados.controllers;

import edu.escuelaing.arep.centificados.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public String login(@RequestBody List<String> authentication){
        String hashAuthorized = "f67162fc0ebe1938f429961bfd37dbf4012d0c315ad77705d40aedfc1244dfbaa13dc714fd1851957b7aa6ed20bab8004789e7d66e72004e115be677a45b7dfe";
        String username = authentication.get(0);
        String hashLogin = authenticationService.getHashPassword(authentication.get(1));
        if(hashAuthorized.equals(hashLogin) && username.equals("andres")) {
            return "valid";
        } else {
            return "invalid";
        }
    }
}

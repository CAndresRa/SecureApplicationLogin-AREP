package edu.escuelaing.arep.centificados.services.impl;

import edu.escuelaing.arep.centificados.services.AuthenticationService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String getHashPassword(String password) {
        String hash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(password.getBytes("utf8"));
            hash = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hash;
    }
}

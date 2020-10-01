package edu.escuelaing.arep.centificados.services.impl;

import edu.escuelaing.arep.centificados.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * URL of the service for power number
     */
    private static final String SERVICE_URL = "https://localhost:5001/power";

    @Override
    public Integer calculate(int number) {
        int ans = 0;
        try {
            ans = restTemplate.getForObject(new URI("https://localhost:5001/power?number=" + number), int.class);
        } catch (URISyntaxException e) {
            System.out.println("algo paso");
        }
        return ans;
    }

}

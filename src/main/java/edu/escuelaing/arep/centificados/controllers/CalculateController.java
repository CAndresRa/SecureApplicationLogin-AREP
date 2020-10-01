package edu.escuelaing.arep.centificados.controllers;

import edu.escuelaing.arep.centificados.services.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
    @Autowired
    CalculateService calculateService;

    @GetMapping("/calculate")
    public ResponseEntity<?> getPowerNumber(@RequestParam(value = "number") Integer number) {
        System.out.println(number);
        return new ResponseEntity<>(calculateService.calculate(number), HttpStatus.OK);
    }

}

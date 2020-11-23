package com.apirresponse.api;

import domain.Estudante;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {
    @GetMapping("/home")

    public ResponseEntity <String> inicio(){
        HttpStatus httpStatus = HttpStatus.CREATED;
        return ResponseEntity.status(httpStatus).body("Página inicial da API");

    }
    @PostMapping("/estudante")

    public ResponseEntity<Object> a_post(@RequestBody Estudante estudante) {

        if (estudante.getNome().equalsIgnoreCase("marcio")) {
            HttpStatus httpStatus = HttpStatus.ACCEPTED;
            return ResponseEntity.status(httpStatus).body("Estudante é Marcio.");
        } else {
            HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(httpStatus).body(false);
        }
    }
    @PutMapping("/estudante")

    public ResponseEntity<Boolean> c_put(@RequestBody Estudante estudante) {
        if (estudante.getId() == 0) {
            HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;
            System.out.println(estudante.toString());
            return ResponseEntity.status(httpStatus).body(false);
        } else {
            HttpStatus httpStatus = HttpStatus.OK;
            System.out.println(estudante.toString());
            return ResponseEntity.status(httpStatus).body(true);
        }
    }

}

package com.portalnfsolution.endpoint;

import com.portalnfsolution.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by felipe.simmi on 21/05/2018.
 */

@RestController
@RequestMapping("v1")
public class NotaEndpoint {

    private final NotaRepository repository;

    @Autowired
    public NotaEndpoint(NotaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/protegido/notas")
    public ResponseEntity<?> listarTodos(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }


}

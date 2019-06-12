package simulacao.si.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simulacao.si.classes.Sumario;
import simulacao.si.services.SumarioService;

import java.util.ArrayList;

@RestController
@RequestMapping("/sumario")
public class SumarioController {

    @Autowired
    private SumarioService sumarioService;

    @CrossOrigin
    @RequestMapping(value = "/getsumario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sumario> getSumario(@RequestBody Integer idsumario) {
        Sumario s = sumarioService.getSumario(idsumario);
        return (s == null) ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(s);
    }

}

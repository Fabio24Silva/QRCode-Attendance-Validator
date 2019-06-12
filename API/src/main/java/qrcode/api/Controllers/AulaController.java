package qrcode.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qrcode.api.JsonFiles.AulaJson;
import qrcode.api.Models.Aluno;
import qrcode.api.Models.Aula;
import qrcode.api.Models.CacheObject;
import qrcode.api.Models.Hash;
import qrcode.api.Services.AulaService;
import qrcode.api.Services.CacheObjectService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva
 *         Daniel Pinto
 *         João Caçote
 * @version 1.0
 */
@RestController
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @CrossOrigin
    @RequestMapping(value = "/newAula", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    /**
     * Método que recebe o pedido http para a criação de uma nova aula
     * Retorna uma string com o id + UUID para a aula enviada
     */
    public ResponseEntity<String> newAula(@RequestBody AulaJson aulaJson) {
        String qrcode = aulaService.getUUID(aulaJson);
        return (qrcode == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(qrcode);
    }

    @CrossOrigin
    @RequestMapping(value = "/closeAula", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    /**
     * Método que recebe pedido http para terminar a aula enviada
     * Retorna um arraylist com os alunos e as devidas presenças
     */
    public ResponseEntity<ArrayList<Aluno>> closeAula(@RequestBody long idsumario) {
        ArrayList<Aluno> alunos = aulaService.closeAula(idsumario);
        return (alunos == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(alunos);
    }
}

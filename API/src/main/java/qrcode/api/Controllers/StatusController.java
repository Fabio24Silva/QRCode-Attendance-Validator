package qrcode.api.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/getStatus")
public class StatusController {
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    /**
     * Método para verificar se a API está ativa
     */
    public ResponseEntity<Void> getStatus() {return ResponseEntity.ok(null); }
}

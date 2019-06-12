package qrcode.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qrcode.api.JsonFiles.QrLidoJson;
import qrcode.api.Models.CacheObject;
import qrcode.api.Models.Hash;
import qrcode.api.Services.AulaService;
import qrcode.api.Services.CacheObjectService;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.UUID;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva
 * @version 1.0
 */
@RestController
public class CacheObjectController {
    @Autowired
    private CacheObjectService cacheObjectService;

    @CrossOrigin
    @RequestMapping(value = "/redoAula", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    /**
     * Método que vai ser chamado na view de 5 em 5 segundos para retornar o novo qrcode
     */
    public ResponseEntity<String> getQrCode(@RequestBody Long id) {
        String qrcode_new = cacheObjectService.reDoObject(id);
        return (qrcode_new == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(qrcode_new);
    }

    @CrossOrigin
    @RequestMapping(value = "/validate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    /**
     * Método que será chamado pela app onde envia os dados lidos no qrCode
     */
    public ResponseEntity<Boolean> checkUuID(@RequestBody QrLidoJson field) {
        LocalTime time = LocalTime.now();
        return ResponseEntity.ok(cacheObjectService.checkUuID(field, time));
    }

}
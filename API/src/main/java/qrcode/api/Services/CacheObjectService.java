package qrcode.api.Services;

import org.springframework.stereotype.Service;
import qrcode.api.JsonFiles.QrLidoJson;
import qrcode.api.Models.Aluno;
import qrcode.api.Models.CacheObject;
import qrcode.api.Models.Hash;
import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author Fábio Silva 
 *         Daniel Pinto
 *         João Caçote 
 * @version 1.0
 */
@Service
public class CacheObjectService {

    /**
     * Método onde é instanciado o cacheObject de um sumário
     * @return
     */
    public static CacheObject newObject() {
        UUID uuid = UUID.randomUUID();
        CacheObject cacheObject = new CacheObject(uuid.getLeastSignificantBits(), LocalTime.now());
        return cacheObject;
    }

    /**
     * Atualiza o UUID de uma aula e retorna o mesmo em conjunto com o id da aula
     * @param id
     * @return
     */
    public String reDoObject(Long id) {
        CacheObject cacheObject = Hash.getCacheObjectConcurrentHashMap().get(id);
        Long uuid = UUID.randomUUID().getLeastSignificantBits();
        cacheObject.renew(uuid, LocalTime.now());
        return id + "/" + uuid;
    }

    public boolean checkUuID(QrLidoJson qr, LocalTime t) {
        return checkUuID(qr.getId_Sumario(), qr.getUuid(), t, qr.getPhoneId(), qr.getNumeroDeAluno());
    }

    /**
     * Método que faz todas as verificações necessárias para a marcação da presença
     * @param id
     * @param uuid
     * @param ts
     * @param mac
     * @param aluno
     * @return
     */
    private boolean checkUuID(Long id, Long uuid, LocalTime ts, String mac, int aluno) {
        CacheObject cacheObject = Hash.getCacheObjectConcurrentHashMap().get(id);
        // Verifica se o tempo de leitura está correto
        if (cacheObject.checkUuid(uuid, ts)) {
            // Verifica se o id do aluno existe
            if (Hash.getalunos().containsKey(id)) {
                ConcurrentHashMap<Integer, Aluno> hashMap = Hash.getalunos().get(id);
                // Verifica se o aluno faz parte da aula
                if (hashMap.containsKey(aluno)) {
                    // Verifica se o id do telemóvel ainda não foi utilizado
                    if (!Hash.getphoneIDs().get(id).containsKey(mac)) {
                        Hash.getphoneIDs().get(id).put(mac, aluno);
                        hashMap.get(aluno).setPresenca(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

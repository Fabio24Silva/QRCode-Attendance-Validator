package qrcode.api.Services;

import org.springframework.stereotype.Service;
import qrcode.api.JsonFiles.AulaJson;
import qrcode.api.Models.Aluno;
import qrcode.api.Models.Aula;
import qrcode.api.Models.CacheObject;
import qrcode.api.Models.Hash;
import java.time.LocalTime;
import java.util.ArrayList;
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
public class AulaService {

    /**
     * Recebe a aula do SI e retorna o UUID em conjunto com o id do sumário
     * @param aulaJson
     * @return
     */
    public String getUUID(AulaJson aulaJson) {
        Aula aula = newAula(aulaJson.getId_sumario(), aulaJson.getHoraInicio(), aulaJson.getHoraFim(), aulaJson.getAlunos());
        return aulaJson.getId_sumario() + "/" + Hash.getCacheObjectConcurrentHashMap().get(aula.getId_sumario()).getUuid();
    }

    /**
     * Método que instancia uma nova aula
     * Instancia um novo cacheObject
     * Cria uma lista de alunos com os alunos recebidos cuja presença começa a false
     * Cria uma lista vazia para os id's dos telemóveis usados nessa aula
     * @param id_sumario
     * @param horaInicio
     * @param horaFim
     * @param alunos
     * @return
     */
    private Aula newAula(long id_sumario, LocalTime horaInicio, LocalTime horaFim, ArrayList<Aluno> alunos) {
        Aula aula = new Aula(id_sumario, horaInicio, horaFim);
        CacheObject cacheObject = CacheObjectService.newObject();
        ConcurrentHashMap<String, Integer> phoneIds = new ConcurrentHashMap<>();
        ConcurrentHashMap<Integer, Aluno> al = new ConcurrentHashMap<>();
        for (Aluno a : alunos) {
            al.put(a.getNumero(), a);
        }
        Hash.getalunos().put(id_sumario, al);
        Hash.getphoneIDs().put(id_sumario, phoneIds);
        Hash.getCacheObjectConcurrentHashMap().put(id_sumario, cacheObject);
        return aula;
    }

    /**
     * Método que passa para um ArrayList todos os alunos presentes na hashmap da aula enviada
     * @param id_sumario
     * @return
     */
    public ArrayList<Aluno> closeAula(long id_sumario) {
        ArrayList<Aluno> array = new ArrayList<>();
        for (Aluno a : Hash.getalunos().get(id_sumario).values()) {
            array.add(a);
        }
        return array;
    }
}

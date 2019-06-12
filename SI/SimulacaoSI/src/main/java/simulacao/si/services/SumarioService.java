package simulacao.si.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simulacao.si.classes.Sumario;
import simulacao.si.repositories.SumarioRepo;

/**
 *
 * Title: QRCode Attendance API
 *
 * @author João Caçote 
 * @version 1.0
 */

@Service
public class SumarioService {
    @Autowired
    private SumarioRepo sumarioRepo;

    public Sumario getSumario(Integer idSumario) {
        if (sumarioRepo.findByIdSumario((long) idSumario).isPresent()) {
            return sumarioRepo.findByIdSumario((long) idSumario).get();
        }
        return null;
    }
}

package com.eheio.hello.service;

import com.eheio.hello.model.MesurePatient;
import com.eheio.hello.repository.IMesurePatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MesurePatientService implements IMesurePatientService {
    @Autowired
    IMesurePatientRepository mesurePatientRepository;
    @Override
    public List<MesurePatient> findAll() {
        return mesurePatientRepository.findAll();
    }

    @Override
    public List<MesurePatient> findByPatient(int id) {
        return mesurePatientRepository.findByPatient(id);
    }

    @Override
    public void addMesure(MesurePatient mesurePatient) {
        mesurePatientRepository.addMesure(mesurePatient);
    }
}

package com.eheio.hello.service;

import com.eheio.hello.model.MesureConsultation;
import com.eheio.hello.repository.IMesureConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MesureConsultationService implements IMesureConsultationService {
    @Autowired
    IMesureConsultationRepository mesureConsultationRepository;
    @Override
    public void addMesureConsultation(MesureConsultation mesureConsultation) {
        mesureConsultationRepository.addMesureConsultation(mesureConsultation);
    }

    @Override
    public List<MesureConsultation> findAll() {
        return mesureConsultationRepository.findAll();
    }

    @Override
    public List<MesureConsultation> findByConsultation(int id) {
        return mesureConsultationRepository.findByConsultation(id);
    }
}

package com.eheio.hello.service;

import com.eheio.hello.model.Consultation;
import com.eheio.hello.repository.IConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ConsultationService implements IConsultationService {
    @Autowired
    IConsultationRepository consultationRepository;
    @Override
    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation findById(int id) {
        return consultationRepository.findById(id);
    }

    @Override
    public int addConsultation(Consultation consultation) {
        return consultationRepository.addConsultation(consultation);
    }

    @Override
    public int findLastConsultation() {
        return consultationRepository.findLastConsultation();
    }
}

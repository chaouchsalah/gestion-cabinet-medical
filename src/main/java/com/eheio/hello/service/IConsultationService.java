package com.eheio.hello.service;

import com.eheio.hello.model.Consultation;
import com.eheio.hello.model.Mesure;

import java.util.List;

public interface IConsultationService {
    List<Consultation> findAll();
    Consultation findById(int id);
    int addConsultation(Consultation consultation);
    int findLastConsultation();
}

package com.eheio.hello.repository;

import com.eheio.hello.model.Consultation;

import java.util.Date;
import java.util.List;

public interface IConsultationRepository {
    List<Consultation> findAll();
    Consultation findById(int id);
    int addConsultation(Consultation consultation);
    int findLastConsultation();
}

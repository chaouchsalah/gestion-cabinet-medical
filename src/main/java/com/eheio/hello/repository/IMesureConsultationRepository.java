package com.eheio.hello.repository;

import com.eheio.hello.model.MesureConsultation;

import java.util.List;

public interface IMesureConsultationRepository {
    void addMesureConsultation(MesureConsultation mesureConsultation);
    List<MesureConsultation> findAll();
    List<MesureConsultation> findByConsultation(int id);
}

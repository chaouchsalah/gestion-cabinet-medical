package com.eheio.hello.service;

import com.eheio.hello.model.MesureConsultation;

import java.util.List;

public interface IMesureConsultationService {
    void addMesureConsultation(MesureConsultation mesureConsultation);
    List<MesureConsultation> findAll();
}

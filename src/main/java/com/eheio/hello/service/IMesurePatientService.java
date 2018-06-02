package com.eheio.hello.service;

import com.eheio.hello.model.MesurePatient;

import java.util.List;

public interface IMesurePatientService {
    List<MesurePatient> findAll();
    List<MesurePatient> findByPatient(int id);
    void addMesure(MesurePatient mesurePatient);
}

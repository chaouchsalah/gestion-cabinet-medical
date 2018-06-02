package com.eheio.hello.repository;

import com.eheio.hello.model.MesurePatient;

import java.util.List;

public interface IMesurePatientRepository {
    List<MesurePatient> findAll();
    MesurePatient findById(int id);
    List<MesurePatient> findByPatient(int id);
    void addMesure(MesurePatient mesurePatient);
}

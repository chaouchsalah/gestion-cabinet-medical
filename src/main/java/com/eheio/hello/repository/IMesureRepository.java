package com.eheio.hello.repository;

import com.eheio.hello.model.Consultation;
import com.eheio.hello.model.Mesure;

import java.util.List;

public interface IMesureRepository {
    List<Mesure> findAll();
    Mesure findById(int id);
}

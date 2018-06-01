package com.eheio.hello.service;

import com.eheio.hello.model.Mesure;

import java.util.List;

public interface IMesureService {
    List<Mesure> findAll();
    Mesure findById(int id);
}

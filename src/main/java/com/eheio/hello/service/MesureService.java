package com.eheio.hello.service;

import com.eheio.hello.model.Mesure;
import com.eheio.hello.repository.IMesureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MesureService implements IMesureService {
    @Autowired
    IMesureRepository mesureRepository;
    @Override
    public List<Mesure> findAll() {
        return mesureRepository.findAll();
    }

    @Override
    public Mesure findById(int id) {
        return mesureRepository.findById(id);
    }
}

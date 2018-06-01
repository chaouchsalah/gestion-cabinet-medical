package com.eheio.hello.service;

import com.eheio.hello.model.Maladie;
import com.eheio.hello.repository.IMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MaladieService implements IMaladieService {
    @Autowired
    IMaladieRepository maladieRepository;
    @Override
    public int addMaladie(Maladie maladie) {
        int nbr = this.maladieRepository.numberOfMaladies(maladie.getLibelle());
        if(nbr ==0){
            int id = this.maladieRepository.addMaladie(maladie);
            return id;
        }
        return -1;
    }

    @Override
    public Maladie findById(int id) {
        return this.maladieRepository.findById(id);
    }
}

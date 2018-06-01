package com.eheio.hello.repository;

import com.eheio.hello.model.Maladie;
import org.hibernate.Session;

public interface IMaladieRepository {
    int addMaladie(Maladie maladie);
    Maladie findById(int id);
    int numberOfMaladies(String libelle);
    Session getCurrentSession();
}

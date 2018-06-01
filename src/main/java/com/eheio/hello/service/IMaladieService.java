package com.eheio.hello.service;

import com.eheio.hello.model.Maladie;

public interface IMaladieService {
    int addMaladie(Maladie maladie);
    Maladie findById(int id);
}

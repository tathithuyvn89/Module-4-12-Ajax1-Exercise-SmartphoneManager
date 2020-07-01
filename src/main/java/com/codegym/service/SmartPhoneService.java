package com.codegym.service;

import com.codegym.model.SmartPhone;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();
    SmartPhone findPhoneById(int id);
    SmartPhone save(SmartPhone smartPhone);
    SmartPhone remove(int id);

}

package com.codegym.service.Impl;

import com.codegym.model.SmartPhone;
import com.codegym.repository.SmartPhoneRepository;
import com.codegym.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    private SmartPhoneRepository smartPhoneRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public SmartPhone findPhoneById(int id) {
        return smartPhoneRepository.findOne(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public SmartPhone remove(int id) {
        SmartPhone smartPhone = smartPhoneRepository.findOne(id);
        smartPhoneRepository.delete(id);
        return smartPhone;
    }
}

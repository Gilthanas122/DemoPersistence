package com.demojpa.demo.service;

import com.demojpa.demo.domain.Owner;
import com.demojpa.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> returnAllOwner() {
        List<Owner> owners = new ArrayList<>();
        ownerRepository
                .findAll()
                .forEach(owners::add);
        return owners;
    }

    @Override
    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public Owner findById(Long id){
        return ownerRepository.findById(id).get();
    }
}

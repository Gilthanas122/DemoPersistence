package com.demojpa.demo.service;

import com.demojpa.demo.domain.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OwnerService {
    List<Owner> returnAllOwner();
    void addOwner(Owner owner);
    Owner findById(Long id);
}

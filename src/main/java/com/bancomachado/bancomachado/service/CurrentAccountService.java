package com.bancomachado.bancomachado.service;


import com.bancomachado.bancomachado.entity.CurrentAccount;
import com.bancomachado.bancomachado.repository.CurrentAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CurrentAccountService {

    private final CurrentAccountRepository repository;

    public List<CurrentAccount> findAll(){
        return repository.findAll();
    }

    public Optional<CurrentAccount> findById(Long id){
        return repository.findById(id);
    }

    public CurrentAccount save(CurrentAccount account){
        return repository.save(account);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}

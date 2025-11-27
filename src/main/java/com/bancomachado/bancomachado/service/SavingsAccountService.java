package com.bancomachado.bancomachado.service;

import com.bancomachado.bancomachado.entity.SavingsAccount;
import com.bancomachado.bancomachado.repository.SavingsAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SavingsAccountService {

    private final SavingsAccountRepository repository;

    public List<SavingsAccount> findAll(){
        return repository.findAll();
    }

    public Optional<SavingsAccount> findById(Long id){
        return repository.findById(id);
    }

    public SavingsAccount save(SavingsAccount savingsAccount){
        return repository.save(savingsAccount);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}

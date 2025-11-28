package com.bancomachado.bancomachado.controller;


import com.bancomachado.bancomachado.SavingsAccountMapper;
import com.bancomachado.bancomachado.controller.Response.SavingsAccountResponse;
import com.bancomachado.bancomachado.controller.request.SavingsAccountRequest;
import com.bancomachado.bancomachado.entity.SavingsAccount;
import com.bancomachado.bancomachado.service.SavingsAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/savings")
public class SavingsAccountController {

    private final SavingsAccountService service;

    @GetMapping
    public ResponseEntity<List<SavingsAccountResponse>> findAll(){
        List<SavingsAccountResponse> accounts = service.findAll()
                .stream()
                .map(SavingsAccountMapper::toSavingsAccountResponse)
                .toList();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/id")
    public ResponseEntity<SavingsAccountResponse> findById(@PathVariable Long id){
        return service.findById(id)
                .map(account -> ResponseEntity.ok().body(SavingsAccountMapper.toSavingsAccountResponse(account)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<SavingsAccountResponse> save(@RequestBody SavingsAccountRequest request){
        SavingsAccount newAccount = SavingsAccountMapper.toSavingsAccount(request);
        SavingsAccount savedAccount = service.save(newAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(SavingsAccountMapper.toSavingsAccountResponse(savedAccount));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<SavingsAccount> optAccount = service.findById(id);
        if(optAccount.isPresent()){
            service.delete(id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}

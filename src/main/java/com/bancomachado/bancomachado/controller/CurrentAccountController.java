package com.bancomachado.bancomachado.controller;


import com.bancomachado.bancomachado.Mapper.CurrentAccountMapper;
import com.bancomachado.bancomachado.controller.Response.CurrentAccountResponse;
import com.bancomachado.bancomachado.controller.request.CurrentAccountRequest;
import com.bancomachado.bancomachado.entity.CurrentAccount;
import com.bancomachado.bancomachado.entity.SavingsAccount;
import com.bancomachado.bancomachado.service.CurrentAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/current")
public class CurrentAccountController {

    private final CurrentAccountService service;

    @GetMapping
    public ResponseEntity<List<CurrentAccountResponse>> findAll(){
        List<CurrentAccountResponse> accounts = service.findAll()
                .stream()
                .map(CurrentAccountMapper::toCurrentAccountResponse)
                .toList();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/id")
    public ResponseEntity<CurrentAccountResponse> findById(@PathVariable Long id){
        return service.findById(id)
                .map(account -> ResponseEntity.ok().body(CurrentAccountMapper.toCurrentAccountResponse(account)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CurrentAccountResponse> save(@RequestBody CurrentAccountRequest request){
        CurrentAccount newAccount = CurrentAccountMapper.toCurrentAccount(request);
        CurrentAccount savedAccount = service.save(newAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(CurrentAccountMapper.toCurrentAccountResponse(savedAccount));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<CurrentAccount> optCurrent = service.findById(id);
        if(optCurrent.isPresent()){
            service.delete(id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}

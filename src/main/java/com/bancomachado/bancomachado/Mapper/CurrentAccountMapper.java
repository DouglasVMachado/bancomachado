package com.bancomachado.bancomachado.Mapper;

import com.bancomachado.bancomachado.controller.Response.CurrentAccountResponse;
import com.bancomachado.bancomachado.controller.request.CurrentAccountRequest;
import com.bancomachado.bancomachado.entity.CurrentAccount;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CurrentAccountMapper {

    public CurrentAccount toCurrentAccount(CurrentAccountRequest request){
        return CurrentAccount
                .builder()
                .agency(request.agency())
                .account(request.account())
                .balance(request.balance())
                .build();
    }

    public CurrentAccountResponse toCurrentAccountResponse(CurrentAccount account){
        return CurrentAccountResponse
                .builder()
                .id(account.getId())
                .agency(account.getAgency())
                .account(account.getAccount())
                .balance(account.getBalance())
                .build();
    }

}

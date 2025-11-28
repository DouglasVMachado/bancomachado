package com.bancomachado.bancomachado;

import com.bancomachado.bancomachado.controller.Response.SavingsAccountResponse;
import com.bancomachado.bancomachado.controller.request.SavingsAccountRequest;
import com.bancomachado.bancomachado.entity.SavingsAccount;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SavingsAccountMapper {

    public SavingsAccount toSavingsAccount(SavingsAccountRequest request){
        return SavingsAccount
                .builder()
                .agency(request.agency())
                .account(request.account())
                .balance(request.balance())
                .build();
    }

    public SavingsAccountResponse toSavingsAccountResponse(SavingsAccount account){
        return SavingsAccountResponse
                .builder()
                .id(account.getId())
                .agency(account.getAgency())
                .account(account.getAccount())
                .balance(account.getBalance())
                .build();
    }


}

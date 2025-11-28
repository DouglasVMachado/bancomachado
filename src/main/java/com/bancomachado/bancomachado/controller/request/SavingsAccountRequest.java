package com.bancomachado.bancomachado.controller.request;

public record SavingsAccountRequest(int agency, int account, Long balance) {
}

package com.bancomachado.bancomachado.controller.request;

public record SavingsAccountRequest(int agency, int account, Double balance) {
}

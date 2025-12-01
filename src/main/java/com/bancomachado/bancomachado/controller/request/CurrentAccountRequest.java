package com.bancomachado.bancomachado.controller.request;

public record CurrentAccountRequest(int agency, int account, Double balance) {
}

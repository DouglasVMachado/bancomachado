package com.bancomachado.bancomachado.controller.Response;

import lombok.Builder;

@Builder
public record CurrentAccountResponse(Long id, int agency, int account, Double balance) {
}

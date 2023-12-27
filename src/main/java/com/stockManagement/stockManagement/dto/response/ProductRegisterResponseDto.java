package com.stockManagement.stockManagement.dto.response;

import java.math.BigDecimal;

public record ProductRegisterResponseDto(String name, Integer quantity, BigDecimal price, BigDecimal totalValue) {
}

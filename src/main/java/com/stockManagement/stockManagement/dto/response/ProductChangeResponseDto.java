package com.stockManagement.stockManagement.dto.response;

import java.math.BigDecimal;

public record ProductChangeResponseDto(Integer id, String name, Integer quantity, BigDecimal price, BigDecimal totalValue) {
}

package com.stockManagement.stockManagement.dto.response;

import java.math.BigDecimal;

public record ProductEntryResponseDto(Long id, String name, Integer quantity, BigDecimal price, BigDecimal totalValue) {
}

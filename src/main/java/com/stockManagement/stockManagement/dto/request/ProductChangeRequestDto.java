package com.stockManagement.stockManagement.dto.request;

import java.math.BigDecimal;

public record ProductChangeRequestDto(Integer id, String name, Integer quantity, BigDecimal price) {
}

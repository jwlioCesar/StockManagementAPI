package com.stockManagement.stockManagement.dto.request;

import java.math.BigDecimal;

public record ProductRegisterRequestDto(String name, Integer quantity, BigDecimal price) {
}

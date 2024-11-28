package com.teamz.order.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.teamz.order.entity.OrderLine;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse {
    private Integer id;
    private BigDecimal totalAmount;
    private LocalDateTime createdDate;
    private Integer customerId;


}
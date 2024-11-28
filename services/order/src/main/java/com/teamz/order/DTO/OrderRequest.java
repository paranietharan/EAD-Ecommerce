package com.teamz.order.DTO;

import com.teamz.order.entity.OrderLine;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {
    private BigDecimal totalAmount;
    private List<OrderLine> orderLines;
    private Integer customerId;
}

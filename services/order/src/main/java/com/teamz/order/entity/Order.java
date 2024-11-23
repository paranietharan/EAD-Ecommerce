package com.teamz.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;
    private BigDecimal totalAmount;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
}

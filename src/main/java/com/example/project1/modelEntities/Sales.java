package com.example.project1.modelEntities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
@Data
@Entity
@Table(name="sales",schema = "shopping")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_generator")
    @SequenceGenerator(name = "sales_generator", sequenceName = "sales_seq", allocationSize = 1)
    @Column(name = "id")
    public Integer orderId;
    @Column(name = "total_amount")
    public Integer totalAmount;
    @Column(name = "date")
    public LocalDate date;
}

package com.example.project1.modelEntities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="sale_items",schema = "shopping")
public class SaleItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_items_generator")
    @SequenceGenerator(name = "sale_items_generator", sequenceName = "sale_items_seq", allocationSize = 1)
    @Column(name = "id")
    public Integer id;
    @Column(name = "order_id")
    public int orderid;
    @Column(name = "key")
    public int productid;
    @Column(name = "amount")
    public Integer amount;
    @Column(name = "quantity")
    public Integer quantity;

}

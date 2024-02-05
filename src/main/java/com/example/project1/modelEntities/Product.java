package com.example.project1.modelEntities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name="products",schema = "shopping")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_generator")
    @SequenceGenerator(name = "products_generator", sequenceName = "products_seq", allocationSize = 1)
    @Column(name ="key")
    public Integer key;
    @Column(name ="name")
    public String name;
    @Column(name ="available")
    public Integer available;
    @Column(name ="quantity")
    public  Integer quantity;
    @Column(name = "category_id")
    public String category;
    @Column(name = "mrp_price")
    public Integer mrp_price;

}

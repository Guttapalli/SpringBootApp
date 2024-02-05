package com.example.project1.Repository;

import com.example.project1.modelEntities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository <Product,Integer>{


}

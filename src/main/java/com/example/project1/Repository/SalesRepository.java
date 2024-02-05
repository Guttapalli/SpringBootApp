package com.example.project1.Repository;

import com.example.project1.modelEntities.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Sales,Object> {
}

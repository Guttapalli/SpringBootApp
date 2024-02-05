package com.example.project1.Repository;

import com.example.project1.modelEntities.SaleItems;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesItemsRepository extends CrudRepository<SaleItems,Object> {
}

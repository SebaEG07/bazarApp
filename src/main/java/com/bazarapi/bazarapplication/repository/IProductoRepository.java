package com.bazarapi.bazarapplication.repository;

import com.bazarapi.bazarapplication.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
    
}

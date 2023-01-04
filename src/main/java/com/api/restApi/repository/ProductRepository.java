package com.api.restApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.restApi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

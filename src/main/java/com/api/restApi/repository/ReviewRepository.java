package com.api.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.restApi.entity.Review;


public interface ReviewRepository extends JpaRepository<Review, String>  {

}

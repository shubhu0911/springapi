package com.api.restApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restApi.entity.Review;
import com.api.restApi.repository.ReviewRepository;


@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ReviewController {

	@Autowired
	ReviewRepository repo;

	@GetMapping(path = "/review", produces = { "application/json" })
	public List<Review> getAllComments() {
		return repo.findAll();
	}

	@GetMapping(path = "/review/{reviewID}", produces = { "application/json" })
	public Optional<Review> getComment(@PathVariable("reviewID") String reviewID) {
		return repo.findById(reviewID);
	}

	@PostMapping(path = "/review", produces = { "application/json" })
	@ResponseBody
	public Review addreview(@RequestBody Review review) {
		System.out.println(review.getReviewID());
		repo.save(review);
		return review;
	}

	@PutMapping(path = "/review", produces = { "application/json" })
	@ResponseBody
	public Review updateBook(@RequestBody Review review) {

		repo.save(review);

		return review;
	}

	@DeleteMapping("/review/{reviewID}")
	public String deleteComment(@PathVariable String reviewID) {

		Review review = repo.getOne(reviewID);
		repo.delete(review);
		return "deleted";
	}

}

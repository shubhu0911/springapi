package com.api.restApi.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.api.restApi.entity.Reply;
import com.api.restApi.repository.ReplyRepository;


@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class ReplyController {
	
	 @Autowired
	  ReplyRepository repo;
	  
	  
		@GetMapping(path="/reply",produces={"application/json"})
	    public List<Reply> getAllReply() {
			return repo.findAll();
		}
		
		@GetMapping(path="/reply/{reviewID}",produces={"application/json"})
		public List<Reply> getReply(@PathVariable("reviewID") String reviewID) {
			List<Reply> replyForReview = null;
			replyForReview = repo.findAll();
			
			 List<Reply> replyList =  replyForReview.stream()  
	                 .filter(o ->o.getReviewID()== reviewID)          
	                 .collect(Collectors.toList());  
			
			return replyList;
		}
		
		@PostMapping(path="/reply",produces= {"application/json"})
		@ResponseBody
		public Reply addReply(@RequestBody Reply reply) {
			System.out.println(reply.getReplyID());
			repo.save(reply);
			return reply;
		}
		@PutMapping(path="/reply",produces= {"application/json"})
		@ResponseBody
		public Reply editReply(@RequestBody Reply reply) {
			System.out.println(reply.getReplyID());
			repo.save(reply);
			return reply;
		}
		
		@DeleteMapping("/reply/{replyID}")
		public String deleteBook(@PathVariable String replyID) {
			
			Reply reply=repo.getOne(replyID);
			repo.delete(reply);
			return "deleted";
		}

}

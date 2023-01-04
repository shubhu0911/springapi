package com.api.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.restApi.entity.Reply;


public interface ReplyRepository extends JpaRepository<Reply, String> {

}

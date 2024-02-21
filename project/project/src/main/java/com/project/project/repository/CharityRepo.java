package com.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.project.model.charity;

@Repository
public interface CharityRepo extends JpaRepository<charity,Integer>{
}
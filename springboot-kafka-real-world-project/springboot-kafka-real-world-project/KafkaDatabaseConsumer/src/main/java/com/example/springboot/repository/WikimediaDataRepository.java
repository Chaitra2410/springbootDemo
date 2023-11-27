package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}

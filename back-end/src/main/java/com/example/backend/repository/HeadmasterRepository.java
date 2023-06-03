package com.example.backend.repository;

import com.example.backend.model.Headmaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadmasterRepository extends JpaRepository<Headmaster, Long> {
}
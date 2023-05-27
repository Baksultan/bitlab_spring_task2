package com.example.spring_sprint2.repository;

import com.example.spring_sprint2.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppReqRepository extends JpaRepository<ApplicationRequest, Long> {
}

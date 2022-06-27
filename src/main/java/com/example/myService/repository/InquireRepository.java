package com.example.myService.repository;

import com.example.myService.entity.Inquire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquireRepository extends JpaRepository<Inquire, Long> {
}

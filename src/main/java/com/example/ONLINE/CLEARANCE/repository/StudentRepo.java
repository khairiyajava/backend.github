package com.example.ONLINE.CLEARANCE.repository;

import com.example.ONLINE.CLEARANCE.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}

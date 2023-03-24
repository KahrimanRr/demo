package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo
        extends JpaRepository <Customer,Integer>{


}

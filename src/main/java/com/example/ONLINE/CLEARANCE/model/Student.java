package com.example.ONLINE.CLEARANCE.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Student {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int stu_Id;
    public String name;
    public Date date;
    public String enrollment_status;

}

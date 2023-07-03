package com.example.ONLINE.CLEARANCE.controller;

import com.example.ONLINE.CLEARANCE.model.Student;
import com.example.ONLINE.CLEARANCE.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/V1")
@CrossOrigin("http://localhost:3000")
public class StudentApi {
    @Autowired
    public StudentRepo studentRepo;

    @PostMapping("insert")
    public ResponseEntity<?> add(@RequestBody Student student){
        try {
            Student student1 =studentRepo.save(student);
            return new ResponseEntity<>("Enserted", HttpStatus.ACCEPTED);

        }catch(Exception exception){
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Get_all")
    public ResponseEntity<?>all(){
        try{
            List<Student>studentList= studentRepo.findAll();
            if (studentList.isEmpty()){
                return new ResponseEntity<>("no data found",HttpStatus.BAD_REQUEST);

            }else {
                return new ResponseEntity<>(studentList,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getbyId/{Stu_Id}")
    public ResponseEntity<?>StudentbyId(@PathVariable int Stu_Id){
        Optional<Student>optionalStudent =studentRepo.findById(Stu_Id);
        try {
            if (optionalStudent.isEmpty()){
                return new ResponseEntity<>("no data found",HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(optionalStudent,HttpStatus.ACCEPTED);
            }
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("delete/{Id}")
    public ResponseEntity<?>deletedaifat(@PathVariable int Id){
        try {
            studentRepo.deleteById(Id);
            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("no data deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{Id}")
    public ResponseEntity<?>updatestudent(@PathVariable int Id, @RequestBody Student student){
        try{
           if(studentRepo.findById(Id).isPresent()){
               Student student1 = studentRepo.save(student);
               student1.setDate(student.getDate());
               student1.setName(student.getName());

               Student updateStudent =studentRepo.save(student1);
               return new ResponseEntity<>("update",HttpStatus.OK);

           }else{
               return new ResponseEntity<>("no update",HttpStatus.CONFLICT);
           }
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }
}

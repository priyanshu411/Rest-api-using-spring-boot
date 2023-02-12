package com.example.demo.repositorys;
import com.example.demo.beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student,Integer> {

}

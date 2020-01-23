package net.fullproject.spring_fullproject.Repository;

import net.fullproject.spring_fullproject.Entity.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository <Student , Long> {
    List<Student> findByName(String name);



}

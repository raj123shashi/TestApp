package com.shashi.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.shashi.crud.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}

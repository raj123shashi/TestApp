package com.shashi.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shashi.crud.model.Student;
import com.shashi.crud.repository.StudentRepository;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@RequestMapping(path = "/student",method = RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student) {
		System.out.println("from Student method");
		studentRepo.save(student);
		return student;
	}
	
	@RequestMapping(path = "/allStudents",method = RequestMethod.GET)
	public List<Student> readStudent(Student student) {
		System.out.println("from Get All Student method");
		List<Student> students=(List<Student>) studentRepo.findAll();
		return students;
	}
	

	@RequestMapping(path = "/oneStudent/{sid}",method = RequestMethod.GET)
	public Student readOneStudent(@PathVariable("sid") Integer id) {
		System.out.println("from Get One Student method");
	 Student student=studentRepo.findById(id).get();
		return student;
	}
	
	@RequestMapping(path = "/deleteStudent/{sid}",method = RequestMethod.DELETE)
	public Integer deleteStudent(@PathVariable("sid") Integer id) {
		System.out.println("from Delete Student method");
	 studentRepo.deleteById(id);
		return id;
	}
	
	@RequestMapping(path = "/updateStudent", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		System.out.println("from Update Student method");
	     studentRepo.save(student);
		return student;
	}
	
	
	
	
	@RequestMapping(path = "/updateStudentAge/{sid}",method = RequestMethod.PATCH)
	public Student updateAge(@PathVariable("sid") Integer id,
			@RequestBody Student fromstudent) {
		System.out.println("Update Age ");
		Student student=studentRepo.findById(id).get();
		student.setAge(fromstudent.getAge());
		studentRepo.save(student);
		return student;
	}
	
	
	
	
	
	

}

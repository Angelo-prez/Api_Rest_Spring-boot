package com.example.crudMVC.service;

import com.example.crudMVC.entity.Student;
import com.example.crudMVC.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
     // se proceden a crear los diferentes servicios
    //listar todos los usuarios
    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }
    //listar el usuario por Id
    public Optional<Student> getStudents(Long id){
        return  studentRepository.findById(id);
    }
    //Guardar y actualizar en la misma funcion para hacer lo mas legible el codigo
    public void saveOrUpdate(Student student){
        studentRepository.save(student);
    }
    //Eliminar o borrar un registro por medio del Id del usuario
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}

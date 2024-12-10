package com.example.crudMVC.controller; //Define el paquete al que pertenece la clase StudentController.

import com.example.crudMVC.entity.Student;
//Importa la clase Student, que es la entidad sobre la que se realizarán las operaciones CRUD.
import com.example.crudMVC.service.StudentService;
//Importa la clase StudentService, que proporciona la lógica de negocio para las operaciones CRUD.
import org.springframework.beans.factory.annotation.Autowired;
//Importa la anotación @Autowired, que se utiliza para inyectar dependencias.
import org.springframework.web.bind.annotation.*;
//Importa las anotaciones de Spring para definir endpoints REST (@RestController, @RequestMapping, @GetMapping, @PostMapping, @DeleteMapping, etc.).
import java.util.List;
// Importa la clase List, que se utiliza para representar una lista de estudiantes.
import java.util.Optional;
//Importa la clase Optional, que se utiliza para manejar la posibilidad de que un estudiante no exista.

@RestController
    /*
    Anotación de Spring que marca la clase StudentController
    como un controlador REST. Esto permite que Spring maneje
    las solicitudes HTTP y devuelva respuestas en formato JSON.
    */
@RequestMapping(path = "api/v1/students")
    /*
    Anotación de Spring que mapea todas las solicitudes
    que comiencen con api/v1/students al controlador StudentController.
    */
public class StudentController { //se define la clase publica.

    @Autowired
    /*
    Anotación de Spring que inyecta automáticamente una instancia
    de StudentService en la clase StudentController.
    */
    private StudentService studentService;
    //Declara un campo privado de tipo StudentService llamado studentService.

    @GetMapping
    /*
    Anotación de Spring que mapea las solicitudes HTTP GET a este método.
    Cuando se accede a la URL base (api/v1/students), se ejecuta este método.
    */
    public List<Student> getAll() {
        /*
        Define un método público llamado getAll que devuelve una
        lista de estudiantes (List<Student>).
         */
        return studentService.getStudents();
        /*
        Llama al método getStudents() del servicio studentService
        para obtener todos los estudiantes y los devuelve.
        */
    }

    @GetMapping("/{studentId}")
    /*
    Anotación de Spring que mapea las solicitudes HTTP GET
    que incluyen un parámetro de ruta ({studentId}) a este método.
    */
    public Optional<Student> getBId(@PathVariable("studentId") long studentId) {
        /*
        Define un método público llamado getBId que recibe un ID de estudiante
        como parámetro de ruta (@PathVariable("studentId")) y devuelve un Optional<Student>.
        */
        return studentService.getStudent(studentId);
        /*
        Llama al método getStudent(studentId) del servicio studentService
        para obtener el estudiante con el ID especificado y lo devuelve.
        */
    }

    @PostMapping
    /*
    Anotación de Spring que mapea las solicitudes HTTP POST a este método.
     */
    public Student saveUpdate(@RequestBody Student student) {
        /*
        Define un método público llamado saveUpdate que recibe un objeto Student
        en el cuerpo de la solicitud (@RequestBody) y devuelve el mismo objeto Student.
        */
        studentService.saveOrUpdate(student);
        /*
        Llama al método saveOrUpdate(student) del servicio studentService
        para guardar o actualizar el estudiante en la base de datos.
        */
        return student; //Devuelve el objeto Student que se acaba de guardar o actualizar.
    }

    @DeleteMapping("/{studentId}")
    /*
    Anotación de Spring que mapea las solicitudes HTTP DELETE
    que incluyen un parámetro de ruta ({studentId}) a este método.
    */
    public void deleteById(@PathVariable("studentId") Long studentId) {
        /*
        Define un método público llamado deleteById que recibe
        un ID de estudiante como parámetro de ruta (@PathVariable("studentId"))
        y no devuelve ningún valor (void).
        */
        studentService.delete(studentId);
        /*
        Llama al método delete(studentId) del servicio studentService
        para eliminar el estudiante con el ID especificado de la base de datos.
        */
    }
}

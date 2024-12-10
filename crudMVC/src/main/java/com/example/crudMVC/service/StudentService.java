package com.example.crudMVC.service; //Define el paquete al que pertenece la clase StudentService.

import com.example.crudMVC.entity.Student;
//Importa la clase Student, que es la entidad sobre la que se realizarán las operaciones CRUD.
import com.example.crudMVC.repository.StudentRepository;
// Importa la interfaz StudentRepository, que proporciona métodos para interactuar con la base de datos.
import org.springframework.beans.factory.annotation.Autowired;
//Importa la anotación @Autowired, que se utiliza para inyectar dependencias.
import org.springframework.stereotype.Service;
//Importa la anotación @Service, que se utiliza para marcar la clase como un componente de servicio de Spring.
import java.util.List;
//Importa la clase List, que se utiliza para representar una lista de estudiantes.
import java.util.Optional;
//Importa la clase Optional, que se utiliza para manejar la posibilidad de que un estudiante no exista.

@Service
    //Anotación de Spring que marca la clase StudentService como un componente de servicio. Esto permite que Spring la detecte automáticamente y la gestione como un bean.
public class StudentService { //Define una clase pública
    @Autowired // Anotación de Spring que inyecta automáticamente una instancia de StudentRepository en la clase StudentService.
    StudentRepository studentRepository; //Declara un campo privado de tipo StudentRepository llamado studentRepository.

    // se proceden a crear los diferentes servicios
    //listar todos los usuarios
    //Define un método público llamado getStudents que devuelve una lista de estudiantes (List<Student>).
    public List<Student> getStudents() {
        return studentRepository.findAll();
        /*
        Llama al método findAll() del repositorio studentRepository para obtener
        todos los estudiantes y los devuelve.
        */
    }

    //listar el usuario por Id
    //Define un método público llamado getStudent que recibe un ID de estudiante (Long id) y devuelve un Optional<Student>.
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
        /*
        Llama al método findById(id) del repositorio studentRepository
        para buscar un estudiante por su ID y lo devuelve.
        */
    }

    //Guardar y actualizar en la misma función para hacer lo más legible el código
    //Define un método público llamado saveOrUpdate que recibe un objeto Student y no devuelve ningún valor (void).
    public void saveOrUpdate(Student student) {
        studentRepository.save(student);
        /*
        Llama al método save(student) del repositorio studentRepository
        para guardar o actualizar el estudiante en la base de datos.
        */
    }

    //Eliminar o borrar un registro por medio del Id del usuario
    //Define un método público llamado delete que recibe un ID de estudiante (Long id) y no devuelve ningún valor (void).
    public void delete(Long id) {
        studentRepository.deleteById(id);
        /*
        Llama al método deleteById(id) del repositorio studentRepository
        para eliminar el estudiante con el ID especificado de la base de datos.
        */
    }
}

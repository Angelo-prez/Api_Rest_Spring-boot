package com.example.crudMVC.repository; //Define el paquete al que pertenece la interfaz StudentRepository.

import com.example.crudMVC.entity.Student; //Importa la clase Student, que es la entidad sobre la que se realizarán las operaciones CRUD.
import org.springframework.data.jpa.repository.JpaRepository; //Importa la interfaz JpaRepository, que proporciona métodos para realizar operaciones CRUD sobre entidades JPA.
import org.springframework.stereotype.Repository; //Importa la anotación @Repository, que se utiliza para marcar la interfaz como un componente de repositorio de Spring.

@Repository
// Anotación de Spring que marca la interfaz StudentRepository como un componente de repositorio. Esto permite que Spring lo detecte automáticamente y lo gestione como un bean.
public interface StudentRepository extends JpaRepository<Student, Long> { //Define una interfaz pública llamada StudentRepository que extiende JpaRepository. La interfaz JpaRepository toma dos parámetros genéricos.

}

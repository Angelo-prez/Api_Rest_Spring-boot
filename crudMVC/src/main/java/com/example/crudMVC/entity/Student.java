package com.example.crudMVC.entity;//Define el paquete al que pertenece la clase Student.

import jakarta.persistence.*;
import lombok.Data;

@Data
//Anotación de Lombok que genera automáticamente los métodos toString(), equals(), hashCode(), y los métodos getter y setter para todos los campos de la clase.
@Entity //Anotación de JPA que indica que la clase Student es una entidad que se mapea a una tabla en la base de datos.
@Table(name = "tbl_student")
//Anotación de JPA que especifica el nombre de la tabla en la base de datos a la que se mapea la entidad. En este caso, la tabla se llama tbl_student.
public class Student { //definir la clase.
    @Id //Anotación de JPA que indica que este campo es la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Anotación de JPA que especifica que el valor de este campo se generará automáticamente utilizando una estrategia de generación de claves basada en una columna de identidad en la base de datos.
    private Long studentId; //Define un campo privado de tipo Long llamado studentId, que representa el ID del estudiante.

    private String firstName; //Define un campo privado de tipo String llamado firstName, que representa el nombre del estudiante.

    private String lastName; //Define un campo privado de tipo String llamado lastName, que representa el apellido del estudiante.

    @Column(name = "email_address", unique = true, nullable = false)
    //Anotación de JPA que especifica los detalles de la columna en la base de datos.
    private String email; //Define un campo privado de tipo String llamado email, que representa la dirección de correo electrónico del estudiante.
}

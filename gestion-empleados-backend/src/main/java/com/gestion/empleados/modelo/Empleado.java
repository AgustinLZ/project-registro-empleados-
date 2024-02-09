package com.gestion.empleados.modelo;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name="email", length = 60,nullable = false,unique = true)
    private String email;

}

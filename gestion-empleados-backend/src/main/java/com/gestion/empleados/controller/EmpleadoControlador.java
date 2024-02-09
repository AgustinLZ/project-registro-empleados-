package com.gestion.empleados.controller;


import com.gestion.empleados.exceptions.ResourceNotFoundException;
import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.repository.EmpleadoRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"http://localhost:4200"})

public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepository repository;

    @GetMapping("/empleados")
    public List<Empleado> listarTodosEmpleados() {
        return repository.findAll();
    }

    @PostMapping("/empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {

        return repository.save(empleado);
    }

    //Buscamos empleados por id
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no existe el empleado con el ID : " + id));
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado) {
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no existe el empleado con el ID : " + id));
        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());


        Empleado empleadoActualizado = repository.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean >> eliminarEmpleado(@PathVariable long id){
        Empleado empleado = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el empleado con el ID :" + id));
        repository.delete(empleado);
        Map<String,Boolean> respuesta =new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

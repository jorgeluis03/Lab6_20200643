package com.example.lab6_sol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    @NotBlank
    @Size(min=3 , max = 100 , message = "En nombre debe estar  entre 3 y 100 caracteres.")
    private String nombres;

    @Column(nullable = false)
    @NotBlank
    @Size(min=3 , max = 100 , message = "En apellido debe estar  entre 3 y 100 caracteres.")
    private String apellidos;

    @Column(nullable = false)
    @NotBlank
    @Digits(message = "El DNI debe ser un número y tener 8 digitos", integer = 8, fraction = 0)
    @Size(min = 8, max = 8)
    private String dni;

    @Column(nullable = false)
    @NotBlank
    @Digits(integer = 10, fraction = 0)
    @Min(value = 1, message = "Debe ser mayor o igual que 0")
    private int edad;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)

    private int rolid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
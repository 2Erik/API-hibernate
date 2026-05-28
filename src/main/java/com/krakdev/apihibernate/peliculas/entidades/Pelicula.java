package com.krakdev.apihibernate.peliculas.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "duracion", nullable = false)
    private int duracion;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

    @Column(name = "calificacion", nullable = false)
    private double calificacion;

    // Constructor vacío
    public Pelicula() {
    }

    // Constructor con parámetros
    public Pelicula(Long id, String nombre, String director,
            String genero, int duracion,
            boolean disponible, double calificacion) {

        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.disponible = disponible;
        this.calificacion = calificacion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    // toString
    @Override
    public String toString() {
        return "Pelicula [id=" + id
                + ", nombre=" + nombre
                + ", director=" + director
                + ", genero=" + genero
                + ", duracion=" + duracion
                + ", disponible=" + disponible
                + ", calificacion=" + calificacion
                + "]";
    }
}
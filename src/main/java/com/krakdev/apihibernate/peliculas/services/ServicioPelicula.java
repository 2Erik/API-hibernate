package com.krakdev.apihibernate.peliculas.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakdev.apihibernate.peliculas.entidades.Pelicula;
import com.krakdev.apihibernate.peliculas.repository.PeliculaRepository;


@Service
public class ServicioPelicula {

    @Autowired
    private PeliculaRepository repo;

    // Crear
    public Pelicula crear(Pelicula pelicula) {
        return repo.save(pelicula);
    }

    // Listar
    public List<Pelicula> listar() {
        return repo.findAll();
    }

    // Buscar por ID
    public Pelicula buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Actualizar
    public Pelicula actualizar(Long id, Pelicula pelicula) {

        Pelicula existente = buscarPorId(id);

        if (existente == null) {
            return null;
        }

        existente.setNombre(pelicula.getNombre());
        existente.setDirector(pelicula.getDirector());
        existente.setGenero(pelicula.getGenero());
        existente.setDuracion(pelicula.getDuracion());
        existente.setDisponible(pelicula.isDisponible());
        existente.setCalificacion(pelicula.getCalificacion());

        return repo.save(existente);
    }

    // Eliminar
    public boolean eliminar(Long id) {

        Pelicula pelicula = buscarPorId(id);

        if (pelicula == null) {
            return false;
        }

        repo.deleteById(id);
        return true;
    }

    // Buscar por género
    public List<Pelicula> buscarPorGenero(String genero) {
        return repo.findByGenero(genero);
    }

    // Buscar por disponible
    public List<Pelicula> buscarPorDisponible(boolean disponible) {
        return repo.findByDisponible(disponible);
    }
}
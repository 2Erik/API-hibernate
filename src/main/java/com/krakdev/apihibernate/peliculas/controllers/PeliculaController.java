package com.krakdev.apihibernate.peliculas.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krakdev.apihibernate.peliculas.entidades.Pelicula;
import com.krakdev.apihibernate.peliculas.services.ServicioPelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final ServicioPelicula servicio;

    public PeliculaController(ServicioPelicula servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<?> crear(
            @RequestBody Pelicula pelicula) {

        try {

            Pelicula creada = servicio.crear(pelicula);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(creada);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear pelicula");
        }
    }

    @GetMapping
    public ResponseEntity<?> listar() {

        try {

            return ResponseEntity.ok(
                    servicio.listar());

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar peliculas");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(
            @PathVariable Long id) {

        try {

            Pelicula pelicula =
                    servicio.buscarPorId(id);

            if (pelicula == null) {

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Pelicula no encontrada");
            }

            return ResponseEntity.ok(pelicula);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar pelicula");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody Pelicula pelicula) {

        try {

            Pelicula actualizada =
                    servicio.actualizar(id, pelicula);

            if (actualizada == null) {

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No se pudo actualizar");
            }

            return ResponseEntity.ok(actualizada);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar pelicula");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(
            @PathVariable Long id) {

        try {

            boolean eliminado =
                    servicio.eliminar(id);

            if (!eliminado) {

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Pelicula no encontrada");
            }

            return ResponseEntity
                    .ok("Pelicula eliminada");

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar pelicula");
        }
    }

    @GetMapping("/genero")
    public ResponseEntity<?> buscarPorGenero(
            @RequestParam String genero) {

        try {

            return ResponseEntity.ok(
                    servicio.buscarPorGenero(genero));

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar por genero");
        }
    }

    @GetMapping("/disponible")
    public ResponseEntity<?> buscarPorDisponible(
            @RequestParam boolean disponible) {

        try {

            return ResponseEntity.ok(
                    servicio.buscarPorDisponible(disponible));

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar por disponibilidad");
        }
    }
}
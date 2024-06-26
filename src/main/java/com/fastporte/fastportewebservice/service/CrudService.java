package com.fastporte.fastportewebservice.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    T save(T t) throws Exception; //Reggister or update
    void delete(Long id) throws Exception; //Eliminar
    List<T> getAll() throws Exception; //Traer el listado de cualquier objeto
    Optional<T> getById(Long id) throws Exception; //   Traer un objeto por su id
}

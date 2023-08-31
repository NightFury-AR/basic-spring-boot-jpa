package com.basicjpaweb.basicjpaweb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceGeneric<T extends JpaRepository,E> {

    @Autowired
    private T t;

    public List<E> getAllEntities() {
        return t.findAll();
    }
    public void addNewEntity(E entity) {
        t.save(entity);
    }
    public void removeEntity(E entity) {
        t.delete(entity);
    }

}

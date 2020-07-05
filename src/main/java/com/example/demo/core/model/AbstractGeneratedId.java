package com.example.demo.core.model;

import javax.persistence.*;

@MappedSuperclass
public class AbstractGeneratedId {
    @Id
    @GeneratedValue
    Long id;

    public Long getId() {
        return id;
    }
}

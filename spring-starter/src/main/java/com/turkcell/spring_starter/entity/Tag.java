package com.turkcell.spring_starter.entity;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tags")
public class Tag {
    @Id
    @UuidGenerator
    @Column(name="id")
    private UUID id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Product> products;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

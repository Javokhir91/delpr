package ru.gb.spring_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.springframework.stereotype.Component;

@Data
@Entity
public class Book {

    private static long sequence = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;


    public Book(String name) {
        this.id = sequence++;
        this.name = name;
    }

    public Book() {
    }
}

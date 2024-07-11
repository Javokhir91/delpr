package ru.gb.spring_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
public class Reader {
    private static long sequence = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;

    public static long getSequence() {
        return sequence;
    }

    public static void setSequence(long sequence) {
        Reader.sequence = sequence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reader(String name) {
        this.id = sequence++;
        this.name = name;
    }

    public Reader() {
    }
}

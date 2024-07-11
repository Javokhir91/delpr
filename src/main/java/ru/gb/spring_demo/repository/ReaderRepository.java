package ru.gb.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_demo.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}

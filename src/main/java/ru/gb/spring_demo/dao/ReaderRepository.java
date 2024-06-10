package ru.gb.spring_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_demo.model.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}

package ru.gb.spring_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.spring_demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

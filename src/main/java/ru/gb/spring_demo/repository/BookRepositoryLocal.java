//package ru.gb.spring_demo.dao;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//import ru.gb.spring_demo.model.Book;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class BookRepositoryLocal {
//
//    private final List<Book> books;
//
//    public BookRepositoryLocal() {
//        this.books = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData(){
//        books.addAll(List.of(
//            new Book("Изучаем Java"),
//            new Book("Java Полное руководство (12-е издание)"),
//            new Book("Грокаем алгоритмы")
//        ));
//    }
//
//    public Book getBookById(long id){
//        return books.stream()
//                .filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//}

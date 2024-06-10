//package ru.gb.spring_demo.dao;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//import ru.gb.spring_demo.model.Reader;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Repository
//public class ReaderRepositoryLocal {
//
//    private final List<Reader> readers;
//
//    public ReaderRepositoryLocal() {
//        this.readers = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData(){
//        readers.addAll(List.of(
//                new Reader("Жавохир"),
//                new Reader("Анна"),
//                new Reader("Кристина"),
//                new Reader("Артем"),
//                new Reader("Иван")
//        ));
//    }
//
//    public Reader getReaderById(long id){
//        return readers.stream()
//                .filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//}

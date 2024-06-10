package ru.gb.spring_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_demo.model.Book;
import ru.gb.spring_demo.model.Issue;
import ru.gb.spring_demo.model.Reader;
import ru.gb.spring_demo.service.ReaderService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/reader")
public class ReaderController {

    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }


    @GetMapping
    public ResponseEntity<List<Reader>> getAllReader() {
        return ResponseEntity.ok(readerService.getAllReaders());
    }

    @GetMapping("/id")
    public ResponseEntity<Reader> getReaderById(@RequestParam Long id) {
        return ResponseEntity.ok(readerService.getReaderById(id));
    }

    @GetMapping("/{id}/issue")
    public ResponseEntity<List<Issue>> getAllIssuesByReaderId(@PathVariable Long id) {
        List<Issue> issues = readerService.getAllIssuesByReaderId(id);
        return ResponseEntity.ok(issues);
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        return ResponseEntity.ok(readerService.createReader(reader));
    }

    @DeleteMapping("/id")
    public void deleteReaderById(@RequestParam Long id) {
        readerService.deleteReaderById(id);
    }

    @PutMapping("/{id}")
    public Reader updateReader(@PathVariable("id") Long id, @RequestBody Reader reader) {
        return readerService.updateReader(reader);
    }




}

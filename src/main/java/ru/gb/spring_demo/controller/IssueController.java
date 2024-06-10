package ru.gb.spring_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_demo.model.Issue;
import ru.gb.spring_demo.model.IssueDTO;
import ru.gb.spring_demo.model.Reader;
import ru.gb.spring_demo.service.IssueService;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request){
        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
        final Issue issue;
        try {
            issue = issueService.saveIssue(request);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(issue);
    }

    @GetMapping
    public ResponseEntity<List<IssueDTO>> getAllIssues(){
        List<IssueDTO> issueDTOS = issueService.getAllIssues();
        return ResponseEntity.ok(issueDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long id){
        Issue issue = issueService.getIssueById(id);
        if (issue == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(issue);
        }
    }

    @PostMapping("/issue")
    public ResponseEntity<?> issueBook(@RequestParam Long readerId, @RequestParam Issue newIssue){
        return issueService.issueBookToReader(readerId, newIssue);
    }

}

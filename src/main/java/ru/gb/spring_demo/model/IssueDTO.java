package ru.gb.spring_demo.model;

import java.time.LocalDateTime;

public class IssueDTO {

    private Long id;
    private String bookTitle;
    private String readerName;
    private LocalDateTime issueAt;
    private LocalDateTime returnAt;

    public IssueDTO(Long id, String bookTitle, String readerName, LocalDateTime issueAt, LocalDateTime returnAt) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.readerName = readerName;
        this.issueAt = LocalDateTime.now();
        this.returnAt = returnAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public LocalDateTime getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(LocalDateTime issueAt) {
        this.issueAt = issueAt;
    }

    public LocalDateTime getReturnAt() {
        return returnAt;
    }

    public void setReturnAt(LocalDateTime returnAt) {
        this.returnAt = returnAt;
    }



}

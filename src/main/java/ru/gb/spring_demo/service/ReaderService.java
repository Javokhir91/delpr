package ru.gb.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_demo.dao.IssueRepository;
import ru.gb.spring_demo.dao.ReaderRepository;
import ru.gb.spring_demo.model.Book;
import ru.gb.spring_demo.model.Issue;
import ru.gb.spring_demo.model.Reader;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @Autowired
    public ReaderService(IssueRepository issueRepository, ReaderRepository readerRepository) {
        this.issueRepository = issueRepository;
        this.readerRepository = readerRepository;
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public List<Issue> getAllIssuesByReaderId(Long readerId) {
        return issueRepository.findByReaderId(readerId);
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }

    public Reader updateReader(Long id){
        return readerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }


    public Reader updateReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }
}

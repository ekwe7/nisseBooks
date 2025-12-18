package services;

import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import dtos.responses.findBookResponse;

import java.util.List;

public interface BookService {
    AddBookResponse addBook(AddBookRequest request);
    findBookResponse findByBookId(int id);
    List<findBookResponse> findAllBooks();
    void deleteByBookId(int id);
}

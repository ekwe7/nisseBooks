package services;

import data.models.Book;
import data.repositories.BookRepositories;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import dtos.responses.findBookResponse;
import utils.Mapper;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepositories bookRepositories;

    public BookServiceImpl(BookRepositories bookRepositories) {
        this.bookRepositories = bookRepositories;
    }

    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        Book book = Mapper.mapToBook(request);

        Book savedBook = bookRepositories.save(book);
        AddBookResponse addBookResponse = Mapper.mapToAddBookResponse(savedBook);

        return addBookResponse;
    }

    @Override
    public findBookResponse findByBookId(int id) {


        return null;
    }

    @Override
    public List<findBookResponse> findAllBooks() {
        return List.of();
    }

    @Override
    public void deleteByBookId(int id) {

    }


}

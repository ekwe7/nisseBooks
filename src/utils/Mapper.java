package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public class Mapper {

    public static Book mapToBook(AddBookRequest request) {
        Book book = new Book();

        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setId(request.getId());
        book.setIsbn(request.getIsbn());
        book.setPages(request.getPages());
        book.setQuantity(request.getQuantity());

        return book;
    }

    public static AddBookResponse mapToAddBookResponse(Book book) {
        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setId(book.getId());
        addBookResponse.setAuthor(book.getAuthor());
        addBookResponse.setTitle(book.getTitle());

        return addBookResponse;
    }
}

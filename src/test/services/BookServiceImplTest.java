package services;
import data.repositories.BookRepositoriesImpl;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.BookServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceImplTest {
    BookRepositoriesImpl bookRepositories;

    BookService bookService;

    @BeforeEach
    public void setUp() {
        bookRepositories = new BookRepositoriesImpl();

    }

    @Test
    public void canAddBook() {
        AddBookRequest request = new AddBookRequest();

       AddBookResponse addBookResponse = bookService.addBook(request);

    }

}
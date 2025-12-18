package data.repositories;

import data.models.BorrowedBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class BorrowedBookRepositoriesTest {
    private BorrowedBookRepositories repository;
    private BorrowedBook borrowedBook1;
    private BorrowedBook borrowedBook2;

    @BeforeEach
    public void setUp() {
        repository = new BorrowedBookRepositoriesImpl();
        borrowedBook1 = new BorrowedBook();
        borrowedBook1.setBookId(1);
        borrowedBook1.setUserId(101);

        borrowedBook2 = new BorrowedBook();
        borrowedBook2.setBookId(2);
        borrowedBook2.setUserId(102);
    }

    @Test
    public void borrowedBook_repository_isEmpty() {
        assertEquals(0, repository.getCount());
    }

    @Test
    public void saveBook_countIsOne_test() {
        repository.save(borrowedBook1);
        assertEquals(1, repository.getCount());
    }

    @Test
    public void saveTwo_countIsTwo_test() {
        repository.save(borrowedBook1);
        repository.save(borrowedBook2);
        assertEquals(2, repository.getCount());
    }

    @Test
    public void findBookById_fromBorrowedBook_test() {
        borrowedBook1.setBookId(105);
        int id = repository.findById(borrowedBook1);
        assertEquals(105, id);
    }

    @Test
    public void findBookById_borrowBookById_test() {
        repository.save(borrowedBook1);
        repository.save(borrowedBook2);

        BorrowedBook foundBook = repository.findBorrowedBookById(2);

        assertEquals(2, foundBook.getBookId());
        assertEquals(102, foundBook.getUserId());

    }
    @Test
    public void findBorrowedBook_ById_NotFound_test() {
        repository.save(borrowedBook1);
        BorrowedBook found = repository.findBorrowedBookById(104);
        assertNull(found);
    }

    @Test
    public void SaveBorrowedBook_assignId_test() {
        repository.save(borrowedBook1);
        assertEquals(101, borrowedBook1.getUserId());
        assertEquals(1, repository.getCount());

    }

    @Test
    public void borrowedBooks_existById_test() {
        repository.save(borrowedBook1);
        repository.save(borrowedBook2);

        assertTrue(repository.existsBorrowedBookById(1));
        assertTrue(repository.existsBorrowedBookById(2));

    }

    @Test
    public void testDeleteById() {
        repository.saveBorrowedBook(borrowedBook1);
        repository.saveBorrowedBook(borrowedBook2);

        int sizeAfterDelete = repository.deleteById(1);
        assertEquals(1, sizeAfterDelete);
    }

    @Test
    public void deleteByIdInvalidId_throwsexeption_test() {
        repository.saveBorrowedBook(borrowedBook1);
        assertThrows(IllegalArgumentException.class, () -> repository.deleteById(99));
    }

    @Test
    public void deleteByZero_nagativeId_throwsexeption_test() {
        repository.saveBorrowedBook(borrowedBook1);
        assertThrows(IllegalArgumentException.class, () -> repository.deleteById(0));
        assertThrows(IllegalArgumentException.class, () -> repository.deleteById(-1));
    }

    @Test
    public void testDeleteAll() {
        repository.saveBorrowedBook(borrowedBook1);
        repository.saveBorrowedBook(borrowedBook2);

        assertEquals(2, repository.getCount());
        repository.deleteAll();
        assertEquals(0, repository.getCount());
    }

    @Test
    public void testSaveAfterDeleteAll() {
        repository.saveBorrowedBook(borrowedBook1);
        repository.deleteAll();
        repository.saveBorrowedBook(borrowedBook2);

        assertEquals(1, repository.getCount());
    }


}
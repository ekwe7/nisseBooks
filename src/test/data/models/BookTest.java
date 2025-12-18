package data.models;

import data.repositories.BookRepositoriesImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BookTest {
    BookRepositoriesImpl bookRepositories;
    Book book;

    @Before
    public void setup(){
        bookRepositories = new BookRepositoriesImpl();
        Book book = new Book();
    }

    @Test
    public void newBook_repositories_isEmpty(){
        //bookRepositories.getCount();
        Assert.assertEquals(0, bookRepositories.getCount());
    }

    @Test
    public void addBook_countIsOne_test(){
        bookRepositories.save(book);
        Assert.assertEquals(1, bookRepositories.getCount());
    }

    @Test
    public void saveBook_countIsOne_test(){
        Book book = new Book();
        bookRepositories.save(book);
        Assert.assertEquals(1L, bookRepositories.getCount());
    }


    @Test
    public void saveBook_bookIdIsSet_test(){
        Book book = new Book();
        book.setId(1);
        book.setTitle("test");
        bookRepositories.save(book);
        Assert.assertEquals(1L, bookRepositories.findId(book));
    }

    @Test
    public void SaveBook_Book_Is_Returned_Test() {
        Book book = new Book();
        Assert.assertEquals(book, bookRepositories.saveBook(book));

    }

    @Test
    public void SaveBook_Book_Id_IsNotZero_Test() {
        Book book = new Book();
        book.setId(1);
        book.setId(2);
        book.setId(3);
        book.setTitle("G-String");
        book.setTitle("D-String");
        book.setTitle("F-String");
        bookRepositories.save(book);
        bookRepositories.save(book);
        bookRepositories.save(book);
        Assert.assertEquals(3L, bookRepositories. getCount());

    }

    @Test
    public void saveBook_existsById_Test() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("test");
        bookRepositories.save(book);

        Assert.assertFalse(bookRepositories.bookExistById(1));
    }


    @Test
    public void SaveBooks_deleteAll_Test() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("test");
        book.setId(2);

        bookRepositories.save(book);
        bookRepositories.save(book);

        bookRepositories.deleteAll();
        Assert.assertEquals(0L, bookRepositories.getCount());
    }

    @Test
    public void SaveBook_FindBookById_returnBook_Test() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("G-String");
        bookRepositories.save(book);
        Assert.assertEquals(1L, bookRepositories.findBookById(1).getId());
    }




}
package data.repositories;

import data.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoriesImpl implements BookRepositories{
    private List<Book> books = new ArrayList<>();
    private int count;

    public long count(){
        return 0;
    }

    @Override
    public long getCount() {
        return books.size();
    }

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public int findId(Book book1) {
        return book1.getId();
    }

    @Override
    public Book findBookById(int id){
        for (Book book : books) {
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    @Override
    public Book saveBook(Book book) {
        count++;
        books.add(book);
        books.get(count-1).setId(count);
        return book ;
    }

    @Override
    public boolean existsBookById(int id) {
        return id > 0 && id < count;
    }

    @Override
    public int deleteById(int id) {
        validateId(id);
        books.remove(id-1);
        return books.size();

    }

    private void validateId(int id) {
        if (id < 0 || id > count) {
            throw new IllegalArgumentException();
        }
    }

    public boolean bookExistById(int id) {
        return id > 0 && id <= count;
    }

    public void deleteAll() {
        books.clear();
    }

}

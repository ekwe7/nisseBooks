package data.repositories;

import data.models.Book;

public interface BookRepositories {

    long getCount();

    Book save(Book book);

    int findId(Book book);

    Book findBookById(int id);

    Book saveBook(Book book);


    boolean existsBookById(int id);

    int deleteById(int id);
}

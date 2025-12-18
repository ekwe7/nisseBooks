package data.repositories;

import data.models.BorrowedBook;

public interface BorrowedBookRepositories {

    long getCount();

    void save(BorrowedBook borrowedBook1);

    int findById(BorrowedBook borrowedBook);

    BorrowedBook findBorrowedBookById(int id);

    BorrowedBook saveBorrowedBook(BorrowedBook borrowedBook);

    boolean existsBorrowedBookById(int i);

    int deleteById(int id);

    void deleteAll();
}
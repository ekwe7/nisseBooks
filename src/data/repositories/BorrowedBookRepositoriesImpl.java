package data.repositories;

import data.models.BorrowedBook;

import java.util.ArrayList;
import java.util.List;

public class BorrowedBookRepositoriesImpl implements BorrowedBookRepositories {

    private List<BorrowedBook> borrowedBooks = new ArrayList<>();
    private int count;

    @Override
    public long getCount() {
        return borrowedBooks.size();
    }

    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
    }

    @Override
    public int findById(BorrowedBook borrowedBook) {
        return borrowedBook.getBookId();
    }

    @Override
    public BorrowedBook findBorrowedBookById(int id) {
        for (BorrowedBook borrowedBook : borrowedBooks) {
            if (borrowedBook.getBookId() == id) {
                return borrowedBook;
            }
        }
        return null;
    }

    @Override
    public BorrowedBook saveBorrowedBook(BorrowedBook borrowedBook) {
        count++;
        borrowedBooks.add(borrowedBook);
        borrowedBooks.get(count - 1).setUserId(count);
        return borrowedBook;
    }


    @Override
    public boolean existsBorrowedBookById(int id) {
        return id > 0 && id <= count;
    }

    @Override
    public int deleteById(int id) {
        validateId(id);
        borrowedBooks.remove(id - 1);
        return borrowedBooks.size();
    }

    private void validateId(int id) {
        if (id <= 0 || id > count) {
            throw new IllegalArgumentException("Invalid Id: " + id);
        }
    }

    @Override
    public void deleteAll() {
        borrowedBooks.clear();
        count = 0;
    }


}


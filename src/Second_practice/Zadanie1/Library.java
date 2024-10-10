package Second_practice.Zadanie1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private final Map<String, Book> catalogBook;

    private final Map<Integer, Reader> readers;

    public Library() {
        this.catalogBook = new HashMap<>();
        this.readers = new HashMap<>();
    }

    public Book getBook(String name) {
        return this.catalogBook.remove(name);
    }

    public void addToCatalog(Book book) {
        this.catalogBook.putIfAbsent(book.getName(), book);
    }

    public void addReader(Reader reader) {
        this.readers.putIfAbsent(reader.getrId(), reader);
    }

    public List<Book> getCatalog() {
        return this.catalogBook.values().stream().toList();
    }

    public List<Reader> getReaders() {
        return this.readers.values().stream().toList();
    }
    @Override
    public String toString() {
        String res = "";

        //1
        res += "Количество книг в библиотеке: " + getCatalog().size();
        res += "\nКниги:\n";
        for (Book book : getCatalog()) {
            res += "-" + book.getName() + "\n";
        }

        //2
        int count_books_in_readers = 0;
        res += "Количество читателей  в библиотеке: " + getReaders().size();
        res += "\nЧитатели:\n";
        for (Reader reader : getReaders()) {
            res += "-" + reader.getName() + "\n";
            count_books_in_readers+= reader.getTakenBooks().size();
        }

        //3
        res += "Количество книг у читателей: " + count_books_in_readers;

        return res;
    }
}
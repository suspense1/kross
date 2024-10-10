package Second_practice.Zadanie1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        String[] bookNames = new String[] {
                "Книга 1", "Книга 2","Книга 3","Книга 4","Книга 5","Книга 6","Книга 7","Книга 8","Книга 9","Книга 10",
        };

        String[] names = new String[] {
                "Имя 1", "Имя 2", "Имя 3", "Имя 4", "Имя 5"
        };

        Library library = new Library();



        for(int i = 0; i < bookNames.length; i++) {
            library.addToCatalog(new Book(bookNames[i]));
        }

        for(String name : names) {
            library.addReader(new Reader(name));
        }




        List<Book> books = library.getCatalog();
        List<Reader> readers = library.getReaders();
        List<String> book_name = new ArrayList<String>();

        for (Book book : books){
            book_name.add(book.getName());
        }
        for (String name : book_name) {
            int n = new Random().nextInt(readers.size());
            Book b = library.getBook(name);
            readers.get(n).takeBook(b);
        }
        System.out.println(library);


    }
}
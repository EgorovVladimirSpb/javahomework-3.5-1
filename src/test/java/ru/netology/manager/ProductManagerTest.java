package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {


    @Test
    void shouldSearchSmartphoneByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(1, "Iphone 12", 99999, "Apple")};
        Product[] actual = manager.searchBy("IPhone 12");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Smartphone(2, "Galaxy S20", 59999, "Samsung")};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(3, "Lord Of The Rings", 5000, "J.R.R. Tolkien")};
        Product[] actual = manager.searchBy("J.R.R. Tolkien");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {new Book(4, "Harry Potter", 400, "J.K. Rowing")};
        Product[] actual = manager.searchBy("Harry Potter");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddNone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {
                new Smartphone(1, "Iphone 12", 99999, "Apple"),
                new Smartphone(2, "Galaxy S20", 59999, "Samsung"),
                new Book(3, "Lord Of The Rings", 5000, "J.R.R. Tolkien"),
                new Book(4, "Harry Potter", 400, "J.K. Rowing"),
        };

        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMultipleProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {
                new Smartphone(1,"Iphone 12", 99999, "Apple"),
                new Smartphone(2,"Galaxy S20", 59999, "Samsung"),
                new Book(3,"Lord Of The Rings", 5000, "J.R.R. Tolkien"),
                new Book(4, "Harry Potter", 400, "J.K. Rowing"),
                new Smartphone(5, "Nokia 3310", 9999, "Nokia"),
                new Book(6,"Atlas", 2999, "Various Authors"),

        };
        manager.add(new Smartphone(5, "Nokia 3310", 9999, "Nokia"));
        manager.add(new Book(6,"Atlas", 2999, "Various Authors"));
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] expected = {
                new Smartphone(1,"Iphone 12", 99999, "Apple"),
                new Smartphone(2,"Galaxy S20", 59999, "Samsung"),
                new Book(3,"Lord Of The Rings", 5000, "J.R.R. Tolkien"),
                new Book(4, "Harry Potter", 400, "J.K. Rowing"),
                new Smartphone(5, "Nokia 3310", 9999, "Nokia"),

        };
        manager.add(new Smartphone(5, "Nokia 3310", 9999, "Nokia"));
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}
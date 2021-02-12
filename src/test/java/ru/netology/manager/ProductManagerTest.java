package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductManagerTest {
    private ProductManager manager = new ProductManager();
    Smartphone first = new Smartphone(1, "OldSmartphone", 100, "Samsung");
    Smartphone second = new Smartphone(2, "NewSmartphone", 1000, "Apple");
    Smartphone third = new Smartphone(3, "JustSmartphone", 500, "Samsung");
    Book forth = new Book(4, "ABC", 100, "Pushkin");
    Book fifth = new Book(5, "ABC", 100, "NePushkin");
    Book sixth = new Book(6, "Captain's daughter", 50, "Pushkin");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove = 4;
        manager.removeById(idToRemove);
        Product[] expected = new Product[]{first, second, third, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        String text = "Pushkin";
        Product[] expected = new Product[]{forth, sixth};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        String text = "ABC";
        Product[] expected = new Product[]{forth, fifth};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        String text = "NewSmartphone";
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        String text = "Samsung";
        Product[] expected = new Product[]{first, third};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByMissingString() {
        String text = "Plum";
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
        System.out.println("No such product");
    }

    @Test
    void shouldSearchByMissingClass() {
        Tshirt seventh = new Tshirt(7, "White", 30);
        manager.add(seventh);
        String text = "White";
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
        System.out.println("No such product");
    }

}
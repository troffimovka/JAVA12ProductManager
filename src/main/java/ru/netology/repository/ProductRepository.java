package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepository {

    private Product[] items = new Product[0];


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        if (items.length != 0) {
            System.arraycopy(items, 0, tmp, 0, items.length);
        }
        tmp[length - 1] = item;
        items = tmp;
    }


    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int index = 0;
        for (Product item : items) {
            if (item.getId() == id) {
                int length = items.length - 1;
                Product[] tmp = new Product[length];
                for (Product item2 : items) {
                    if (item2.getId() != id) {
                        tmp[index] = item2;
                        index++;
                    }
                }
                items = tmp;
                return;
            }
        }
    }


}

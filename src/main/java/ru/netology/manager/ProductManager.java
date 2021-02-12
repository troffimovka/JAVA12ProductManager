package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

@NoArgsConstructor
@Data
public class ProductManager {
    private ProductRepository repository = new ProductRepository();

//    public ProductManager(ProductRepository repository) {
//        this.repository = repository;
//    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    private boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        if  (product instanceof Smartphone){
            Smartphone smartphone  = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return  true;
            }
            if (smartphone.getManufacturer().equalsIgnoreCase(search)){
                return  true;
            }
            return  false;
        }
        return  false;
    }
}

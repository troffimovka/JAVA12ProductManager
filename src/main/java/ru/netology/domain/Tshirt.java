package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Tshirt extends Product {

    public Tshirt(int id, String name, int price) {
        super(id, name, price);
    }
}
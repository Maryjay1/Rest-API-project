package com.example.CrudOperation.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
        @Column(name = "item_name")
        private String itemName;
        @Column(name = "item_price")
        private long price;
        @Column(name = "item_description")
        private String itemDescription;
        @Column(name = "item_Category")
        private String categoryName;


}

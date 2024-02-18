package com.example.CrudOperation.Dto;

import com.example.CrudOperation.Entity.Product;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
public class ProductDto {

    private long id;
    private String itemName;
    private long price;
    private String itemDescription;
    private String categoryName;

    public ProductDto productToDto(Product product){
        ModelMapper modelMapper=new ModelMapper();
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
    public Product dtoToproduct(ProductDto productDto){
        ModelMapper modelMapper=new ModelMapper();
        Product product = modelMapper.map(productDto, Product.class);
        return product;
    }
}

package com.example.CrudOperation.Service;

import com.example.CrudOperation.Dto.ProductDto;

import java.util.List;

public interface ProductService {

    String addItem(ProductDto productDto) throws Exception;

    List<ProductDto> view() throws Exception;

    String updateItem(ProductDto productDto, long id) throws Exception;

    String deleteProduct(Long id);
}

package com.example.CrudOperation.Service;
import com.example.CrudOperation.Dto.ProductDto;
import com.example.CrudOperation.Entity.Product;
import com.example.CrudOperation.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public String addItem(ProductDto productDto) throws Exception {
        String incomingName=productDto.getItemName();
        Product productExist=productRepository.findByItemName(incomingName);
        if (productExist!=null){
            return "Item Already Exist";
        }else{
            productRepository.save(productDto.dtoToproduct(productDto));
            return "Item Save Successfully ";
        }
    }
    @Override
    public List<ProductDto> view() throws Exception {
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            productDto.add(new ProductDto().productToDto(product));
        }
        return productDto;
    }
    @Override
    public String updateItem(ProductDto productDto,long id) throws Exception {
        Product existingProduct = productRepository.getProductById(id);

        if (existingProduct != null) {
            // Update existing product with new values
            existingProduct.setItemName(productDto.getItemName());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct.setItemDescription(productDto.getItemDescription());
            existingProduct.setCategoryName(productDto.getItemDescription());
            // Save the updated product
            productRepository.save(existingProduct);
            return "Save Successfully";
        } else {
            return "No Item Found";
        }
    }
    @Override
    public String deleteProduct(Long id) {
        Product findProduct = productRepository.getProductById(id);

        if (findProduct != null) {
            productRepository.delete(findProduct);
            return "Delete Successful";
        } else {
            return "No Item Found";
        }
    }
}


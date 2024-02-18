package com.example.CrudOperation.Controller;
import com.example.CrudOperation.Dto.ProductDto;
import com.example.CrudOperation.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product/api")
public class ProductController {
    @Autowired
    public ProductServiceImpl productServiceimpl;
    @GetMapping("/view/products")
    public ResponseEntity<List<ProductDto>> getAllItem() throws Exception {
        {
            return ResponseEntity
                .ok()
                .body(productServiceimpl.view());
    }
    }


    @PostMapping(path = "/add/item")
    public ResponseEntity<String> addItem(@RequestBody ProductDto productDto) throws Exception {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceimpl.addItem(productDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productServiceimpl.updateItem(productDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(productServiceimpl.deleteProduct(id));
        }


}

package com.example.prueba.prueba.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.prueba.prueba.Model.Products;
//Spring pueda utlizar esta clase como co un componente paraq que me epermita usar una inyeccion de depsnedencias
import com.example.prueba.prueba.Repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
// Indica que esta clase es un servicio de Spring
// y que se puede inyectar en otros componentes de la aplicación
@Transactional
// Indica que las operaciones de este servicio deben ser transaccionales
// Esto significa que todas las operaciones dentro de este servicio se ejecutarán en una transacción
//Transaccion es decir que si una falla, todas las operaciones se revertirán
public class ProductsServiceImplement implements ProductsService {

    private final ProductRepository productRepository;
    // Inyección de dependencias del repositorio de productos
    public ProductsServiceImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        //Nos devueleve un iterabe asi que lo casteamos a una lista de productos 
        return (List<Products>)productRepository.findAll();
    }

    @Override
    public Optional<Products> getProductById(Long id) {
        // Retorna un producto por su ID de manera opcional
        return productRepository.findById(id);
    }

    @Override
    public Products createProduct(Products product) {
        // Crea un nuevo producto y lo guarda en la base de datos
        return productRepository.save(product);
    }

    @Override
    public Products updateProduct(Long id, Products product) {
        // Verifica si el producto existe antes de actualizarlo
        if (productRepository.existsById(id)) {
            product.setId(id); // Asegura que el ID del producto sea el correcto
            return productRepository.save(product); // Guarda el producto actualizado
        } else {
            // Si no existe, lanza una excepción o maneja el caso según sea necesario
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        // Elimina un producto por su ID
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            // Si no existe, lanza una excepción o maneja el caso según sea necesario
            throw new RuntimeException("Product not found with id: " + id);
        }
    }


}

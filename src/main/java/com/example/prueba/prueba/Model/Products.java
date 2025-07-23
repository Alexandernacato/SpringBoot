package com.example.prueba.prueba.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String description;
private Double price;

public Products() {
}
public Products(Long id, String name, String description, Double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;     
}
// Getters and Setters
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}   
public String getDescription() {
    return description;
}   
public void setDescription(String description) {
    this.description = description;
}
public Double getPrice() {
    return price;
}
public void setPrice(Double price) {
    this.price = price;
}
//has metodos 


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hanif salafi
 */
public class Product {
    private String id;
    private String name;
    private int price;
    private int stock;

    public Product(String id,String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Product() {
        
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}

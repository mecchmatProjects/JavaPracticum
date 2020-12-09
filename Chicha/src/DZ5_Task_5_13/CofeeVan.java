package DZ5_Task_5_13;

import java.util.ArrayList;

public class CofeeVan {
    protected double volume;
    protected ArrayList<Product> productsInside;

    CofeeVan(){};
    CofeeVan(double volume, ArrayList<Product> productsInside){
        this.volume = volume;
        this.productsInside = productsInside;
    }

    public double getVolume(){
        return volume;
    }

    public ArrayList<Product> getProductsInside(){
        return productsInside;
    }

    public Product getProductByName(String name){
        for (Product product: productsInside) {
            if (product.name.equals(name)) {
                return product;
            }
        }
        return new Product();
    }

    public Product getProductByPrice(double price){
        for (Product product: productsInside) {
            if (product.price == price) {
                return product;
            }
        }
        return new Product();
    }

    public void addProductsFromList(ArrayList<Product> products, double price){
        double currentVolume = 0;
        double currentPrice = 0;
        for (Product product: products){
            currentVolume += product.volumeOfPackage;
            currentPrice += product.price;
            if ((currentPrice <= price)||(currentVolume <= volume)){
                productsInside.add(product);
            }
            else {
                currentVolume -= product.volumeOfPackage;
                currentPrice -= product.price;
            }
        }
    }
}

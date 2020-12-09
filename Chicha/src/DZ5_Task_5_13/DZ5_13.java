package DZ5_Task_5_13;

import java.io.IOException;
import java.util.ArrayList;

public class DZ5_13 {
    public static String fileName = "./src/DZ5_Task_5_13/products_list.txt";

    public static void ListOfProducts(ArrayList<Product> products){
        for (Product product: products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Product> products = Utils.readFile(fileName);
        System.out.println("All products : ");
        ListOfProducts(products);

        Utils.sortByPriceByKilo(products);
        System.out.println("Sorted products : ");
        ListOfProducts(products);

        ArrayList<Product> equalList = new ArrayList<Product>();
        CofeeVan van = new CofeeVan(22, equalList);

        van.addProductsFromList(products, 300);
        System.out.println("Products in the van: ");
        ListOfProducts(van.productsInside);

        String name = "Coffee1";
        System.out.println("Products with name: '" + name + "' from van");
        System.out.println(van.getProductByName(name));

    }
}

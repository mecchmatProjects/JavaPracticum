/*
Чича Олександр

13.Фургон кави. Завантажити фургон певного обєму вантажем на певну суму із різних
сортів кави, що знаходяться, до того-ж, в різних фізичних станах (зерно, мелену,
розчинну в банках і пакетиках). Враховувати обсяг кави разом з упаковкою. Провести
сортування товарів на основі співвідношення ціни і ваги. Знайти в фургоні товар,
відповідний заданому діапазону параметрів якості.
 */

package DZ5_Task_13;


import java.io.IOException;
import java.util.ArrayList;

public class Task5_13 {
    public static String fileName = "/products_list.txt";

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
        CoffeeVan van = new CoffeeVan(22, equalList);

        van.addProductsFromList(products, 300);
        System.out.println("Products in the van: ");
        ListOfProducts(van.productsInside);

        String name = "Coffee1";
        System.out.println("Products with name: '" + name + "' from van");
        System.out.println(van.getProductByName(name));

    }
}

/*
    Чича Олександр

    Завдання 1.9
9.Product: id, Найменування, UPC, Виробник, Ціна, Термін зберігання,
Колічество.Створити масив об&#39;єктів. Вивести: a) список товарів для заданого
найменування; b) список товарів для заданого найменування, ціна яких непревос-
ходить задану; c) список товарів, термін зберігання яких більше заданого.
*/

package DZ4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task19 {
    public static void main(String[] args) throws ParseException {
        Product[] products = Product.createProducts();

        System.out.println("List of all products:");
        for (Product product : products) {
            System.out.println(product);
        }

        String name = "Product17";

        System.out.println();
        System.out.println("List of products with name '" + name + "'");
        for (Product product : products) {
            if (product.getName().equals(name)) {
                System.out.println(product);
            }
        }

        double price = 4000;

        System.out.println();
        System.out.println("List of products with name '" + name + "'" + " and price not higher then '" + price + "'");
        for (Product product : products) {
            if (product.getName().equals(name)&&(product.getPrice()<=price)) {
                System.out.println(product);
            }
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String data = "13.07.2027";

        System.out.println();
        System.out.println("List of products with dateUseBefore higher then '" + data + "'");
        Date date1 = new Date();
        try {
            date1 = formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }

       for (Product product : products) {
            if (date1.compareTo(formatter.parse(product.getDateUseBefore())) < 0) {
                System.out.println(product);
            }
        }

    }
}

class Product {

    private int id;
    private String name;
    private String UPC;
    private String manufacturer;
    private double price;
    private String dateUseBefore;
    private int count;

    public Product() {
    }

    public Product(
            int id,
            String name,
            String UPC,
            String manufacturer,
            double price,
            String dateUseBefore,
            int count
    ) {
        this.id = id;
        this.name = name;
        this.UPC = UPC;
        this.manufacturer = manufacturer;
        this.price = price;
        this.dateUseBefore = dateUseBefore;
        this.count = count;
    }

    public static Product[] createProducts() {
        return new Product[] {
                new Product(12, "Product1", "01234432", "Nike", 3200, "12.12.2030", 100),
                new Product(13, "Product12", "01234454", "Adidas", 4200, "25.12.2022", 150),
                new Product(14, "Product13", "01234423", "Puma", 3120, "12.07.2027", 180),
                new Product(15, "Product14", "01234476", "Adidas", 2200, "15.08.2036", 190),
                new Product(16, "Product15", "01234487", "Puma", 5800, "05.05.2031", 1000),
                new Product(17, "Product16", "01234498", "Nike", 3550, "22.01.2040", 1002),
                new Product(18, "Product17", "01234409", "Asix", 3680, "29.05.2020", 300),
                new Product(19, "Product18", "01234400", "Nb", 3820, "19.11.2028", 8000),
                new Product(20, "Product19", "01234401", "Nike", 4100, "17.02.2035", 120),
        };
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", UPC='" + UPC + "'" +
                ", manufacturer='" + manufacturer + "'" +
                ", price=" + price +
                ", dateUseBefore='" + dateUseBefore + "'" +
                ", count=" + count +
                "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public String geManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateUseBefore() {
        return dateUseBefore;
    }

    public void setDateUseBefore(String dateUseBefore) {
        this.dateUseBefore = dateUseBefore;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

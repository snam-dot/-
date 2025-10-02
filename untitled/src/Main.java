import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return name + " - " + price + "₸";
    }
}

class Cart {
    List<Product> products = new ArrayList<>();
    void add(Product p) { products.add(p); }
    double total() {
        double sum = 0;
        for (Product p : products) sum += p.price;
        return sum;
    }
}

 class Shop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // массив товаров
        Product[] catalog = {
                new Product("Ноутбук", 350000),
                new Product("Телефон", 150000),
                new Product("Наушники", 30000)
        };

        // вывод каталога
        System.out.println("Каталог:");
        for (int i = 0; i < catalog.length; i++) {
            System.out.println((i + 1) + ". " + catalog[i]);
        }

        Cart cart = new Cart();

        // выбор товаров
        System.out.println("Введите номера товаров (0 для завершения):");
        while (true) {
            int choice = sc.nextInt();
            if (choice == 0) break; // выход
            if (choice > 0 && choice <= catalog.length) {
                cart.add(catalog[choice - 1]);
                System.out.println(catalog[choice - 1].name + " добавлен в корзину.");
            } else {
                System.out.println("Нет такого товара!");
            }
        }

        // вывод корзины
        System.out.println("\nКорзина:");
        for (Product p : cart.products) System.out.println(p);
        System.out.println("Итого: " + cart.total() + "₸");
    }
}

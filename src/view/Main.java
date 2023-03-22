package view;

import config.Config;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int choice = 0;

        do {
            System.out.println("****************MENU***************");
            System.out.println("1. Add product");
            System.out.println("2. Show product's information");
            System.out.println("3. Update product");
            System.out.println("4. Delete products by product ID");
            System.out.println("5. Exit");
            System.out.println("Input your choice");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case (1):
                    new ProductView().addProduct();
                    break;
                case 2:
                    new ProductView().showListProduct();
                    break;
                case 3:
                    new ProductView().updateProduct();
                    break;
                case 4:
                    new ProductView().deleteProduct();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (choice < 5);
    }
}

package view;

import config.Config;
import controller.ProductController;
import model.Product;

import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();

    public void showListProduct() {
        System.out.println("====List Product===");
        List<Product> listProduct = productController.showListProduct();
        for (int i = 0; i < listProduct.size(); i++) {
            listProduct.get(i).displayData();
        }
        System.out.println("Enter 'Back' to comeback Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void addProduct() {
        while (true) {
            System.out.println("Input the product's ID");
            int productId = Integer.parseInt(Config.scanner().nextLine());
            System.out.println("Input the product's name");
            String productName = Config.scanner().nextLine();
            System.out.println("Input the product's title");
            String title = Config.scanner().nextLine();
            System.out.println("Input the product's descriptions");
            String descriptions = Config.scanner().nextLine();
            System.out.println("Input the product's import price");
            float importPrice = Float.parseFloat(Config.scanner().nextLine());
            System.out.println("Input the product's export price");
            float exportPrice = Float.parseFloat(Config.scanner().nextLine());
            float interest = (exportPrice - importPrice);
            System.out.println("Input the product's status");
            String productStatus = Config.scanner().nextLine();
            Product product = new Product(productId, productName, title, descriptions, importPrice, exportPrice, interest, (productStatus.equalsIgnoreCase("stock") ? true : false));
            productController.createProduct(product);
            System.out.println("Added success");
            System.out.println("Enter 'Back' to comeback Menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Main();
                break;
            }
        }

    }

    public void updateProduct(){
        System.out.println("Input the product's ID you want to update");
        int id = Integer.parseInt(Config.scanner().nextLine());
        System.out.println("Input the field you want to update");
        String field = Config.scanner().nextLine();
        if(field.equalsIgnoreCase("id")){
            System.out.println("Input the id you want to update");
            int newProductId = Integer.parseInt(Config.scanner().nextLine());
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setProductId(newProductId);
                }
            }
        } else if(field.equalsIgnoreCase("name")){
            System.out.println("Input the name you want to update");
            String newProductName = Config.scanner().nextLine();
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setProductName(newProductName);
                }
            }
        }else if(field.equalsIgnoreCase("title")){
            System.out.println("Input the title you want to update");
            String newTitle = Config.scanner().nextLine();
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setTitle(newTitle);
                }
            }
        }else if(field.equalsIgnoreCase("description")){
            System.out.println("Input the description you want to update");
            String newDescription = Config.scanner().nextLine();
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setDescriptions(newDescription);
                }
            }
        }else if(field.equalsIgnoreCase("import price")){
            System.out.println("Input the import price you want to update");
            float newImportPrice = Float.parseFloat(Config.scanner().nextLine());
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setImportPrice(newImportPrice);
                    productController.showListProduct().get(i).setInterest(productController.showListProduct().get(i).getExportPrice()-newImportPrice);
                }
            }
        }else if(field.equalsIgnoreCase("export price")){
            System.out.println("Input the export price you want to update");
            float newExportPrice = Float.parseFloat(Config.scanner().nextLine());
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setExportPrice(newExportPrice);
                    productController.showListProduct().get(i).setInterest(newExportPrice - productController.showListProduct().get(i).getImportPrice());
                }
            }
        }else if(field.equalsIgnoreCase("status")){
            System.out.println("Input the status price you want to update");
            String newStatus = Config.scanner().nextLine();
            for (int i = 0; i < productController.showListProduct().size(); i++) {
                if(productController.showListProduct().get(i).getProductId()==id){
                    productController.showListProduct().get(i).setProductStatus(newStatus.equalsIgnoreCase("stock")?true:false);
                }
            }
        }
        System.out.println("Updated success");
        System.out.println("Enter 'Back' to comeback Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void deleteProduct(){
        System.out.println("Input product's id you want to delete");
        int id = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < productController.showListProduct().size(); i++) {
            if(productController.showListProduct().get(i).getProductId()==id){
                productController.deleteProduct(id);
            }
        }
        System.out.println("Deleted success");
        System.out.println("Enter 'Back' to comeback Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }
}

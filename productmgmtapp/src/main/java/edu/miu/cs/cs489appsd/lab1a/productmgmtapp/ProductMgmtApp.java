package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;


public class ProductMgmtApp {


    public static void main(String[] args) {
        Product[] products = {
                new Product("3128874119", "Banana", LocalDate.of(2023, 1, 24), 124, 0.55F),
                new Product("2927458265", "Apple", LocalDate.of(2023, 12, 9), 18, 1.09F),
                new Product("9189927460", "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99F)
        };

        printProducts(products);
    }

    public static void printProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getName));

        System.out.println("Printed in JSON Format");
        printProductsAsJson(products);

        System.out.println("\n--------------------------------");
        System.out.println("Printed in XML Format");
        printProductsAsXml(products);

        System.out.println("\n--------------------------------");
        System.out.println("Printed in Comma-Separated Value(CSV) Format");
        printProductsAsCsv(products);
    }

    private static void printProductsAsJson(Product[] products) {
        System.out.println("[");
        for (int i = 0; i < products.length; i++) {
            Product p = products[i];
            System.out.println("  {");
            System.out.println("    \"productId\":\"" + p.getProductId() + "\",");
            System.out.println("    \"name\":\"" + p.getName() + "\",");
            System.out.println("    \"dateSupplied\":\"" + p.getDateSupplied() + "\",");
            System.out.println("    \"quantityInStock\":\"" + p.getQuantityInStock() + "\",");
            System.out.println("    \"unitPrice\":\"" + p.getUnitPrice() + "\"");
            System.out.print("  }" + (i < products.length - 1 ? "," : ""));
            System.out.println();
        }
        System.out.println("]");
    }

    private static void printProductsAsXml(Product[] products) {
        System.out.println("<?xml version=\"1.0\"?>");
        System.out.println("<products>");
        for (Product p : products) {
            System.out.println("  <product productId=\"" + p.getProductId() + "\" name=\"" + p.getName() + "\" " +
                    "dateSupplied=\"" + p.getDateSupplied() + "\" quantityInStock=\"" + p.getQuantityInStock() + "\" " +
                    "unitPrice=\"" + p.getUnitPrice() + "\" />");
        }
        System.out.println("</products>");
    }

    private static void printProductsAsCsv(Product[] products) {
        System.out.println("productId, name, dateSupplied, quantityInStock, unitPrice");
        for (Product p : products) {
            System.out.println(
                    p.getProductId() + ", " +
                            p.getName() + ", " +
                            p.getDateSupplied() + ", " +
                            p.getQuantityInStock() + ", " +
                            p.getUnitPrice()
            );
        }
    }
}
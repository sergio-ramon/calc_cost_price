package calc_cost_price.application;

import calc_cost_price.service.ProductService;

import java.util.Locale;
import java.util.Scanner;

public class ManagerTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        ProductService service = new ProductService(input);

        boolean productMenu = true;
        while(productMenu) {
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Visualizar produtos cadastrados");
            System.out.println("3 - Selecionar produto por ID");
            System.out.println("4 - Deletar produto");
            System.out.println("0 - Sair");
            System.out.print("Selecione a opção desejada: ");
            int option = input.nextInt();
            input.nextLine();

            System.out.println();
            switch (option) {
                case 1 -> service.createProduct();
                case 2 -> service.listProducts();
                case 3 -> service.getProductById();
                case 4 -> service.deleteProduct();
                case 0 -> productMenu = false;
            }
        }
    }
}

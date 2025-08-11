package calc_cost_price.service;

import calc_cost_price.dao.ProductDAO;
import calc_cost_price.model.Product;
import calc_cost_price.model.Supply;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private final ProductDAO productDAO = new ProductDAO();
    Scanner input;

    public ProductService(Scanner input) {
        this.input = input;
    }

    public void createProduct() {
        System.out.println("###### CADASTRO DE PRODUTO ######");
        System.out.println("Digite o nome do produto: ");
        System.out.print(" >> ");
        String productName = input.nextLine();

        System.out.println("Digite a quantidade por receita: ");
        System.out.print(" >> ");
        int productAmount = input.nextInt();
        input.nextLine();

        System.out.println("Quantidade de insumos a cadastrar: ");
        System.out.print(" >> ");
        int supplyAmount = input.nextInt();
        input.nextLine();

        List<Supply> supplies = new ArrayList<>();

        for (int i = 1; i < supplyAmount + 1; i++) {
            System.out.println();
            System.out.println("Selecione o tipo do suprimento: (1 - Preparo | 2 - Embalagem)");
            System.out.print(" >> ");
            int supplyType = input.nextInt();
            input.nextLine();

            String supplyTypeSuffix;
            switch (supplyType) {
                case 1:
                    supplyTypeSuffix = "em gramas";
                    break;
                case 2:
                    supplyTypeSuffix = "";
                    break;
                default:
                    System.out.println("Valor digitado " + supplyType + " inválido");
                    System.out.println();
                    return;
            }

            System.out.println("Digite o nome do suprimento " + i + ": ");
            System.out.print(" >> ");
            String supplyName = input.nextLine();

            System.out.println("Digite o preço do suprimento " + i + ": ");
            System.out.print(" >> ");
            double supplyPrice = input.nextDouble();
            input.nextLine();

            System.out.println("Digite a quantidade do insumo " + i + " por pacote " + supplyTypeSuffix + ": ");
            System.out.print(" >> ");
            int supplyPackageAmount = input.nextInt();
            input.nextLine();

            System.out.println("Digite a quantidade do insumo " + i + " por receita " + supplyTypeSuffix + ": ");
            System.out.print(" >> ");
            int supplyReceiptAmount = input.nextInt();
            input.nextLine();

            supplies.add(new Supply(supplyName, supplyPrice, supplyPackageAmount, supplyReceiptAmount));
        }

        Product product = new Product(null, productName, productAmount, supplies);
        System.out.println(productDAO.create(product));
        System.out.println();
    }

    public void listProducts() {
        List<Product> products = productDAO.list();

        if (products.isEmpty()) {
            System.out.println("Lista de produtos vazia!");
        } else {
            System.out.println("###### PRODUTOS CADASTRADOS ######");
            productDAO.list().forEach(System.out::println);
        }

        System.out.println();
    }

    public void getProductById() {
        System.out.println("###### ACHAR PRODUTO PELO ID ######");
        System.out.println("Digite o ID do produto que deseja achar: ");
        System.out.print(" >> ");
        long id = input.nextLong();
        input.nextLine();

        Product product = productDAO.find(id);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Produto com id " + id + " não localizado");
        }

        System.out.println();
    }

    public void deleteProduct() {
        System.out.println("###### DELETAR PRODUTO ######");
        System.out.println("Digite o ID do produto que deseja deletar: ");
        System.out.print(" >> ");
        long id = input.nextLong();
        input.nextLine();

        System.out.println(productDAO.delete(id));
        System.out.println();
    }
}

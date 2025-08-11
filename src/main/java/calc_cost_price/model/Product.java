package calc_cost_price.model;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private int amount;
    private List<Supply> supplies;
    private double cost;
    private double suggestedPrice;

    public Product(Long id, String name, int amount, List<Supply> supplies) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.supplies = supplies;
        calculatePrice();
    }

    public Product(Long id, String name, int amount, double cost, double suggestedPrice) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.suggestedPrice = suggestedPrice;
    }

    private void calculatePrice() {
        double suppliesTotalPrice = supplies.stream()
                .mapToDouble(Supply::getPrice)
                .sum();

        cost = suppliesTotalPrice / amount;
        suggestedPrice = cost + (cost * 1.5);
    }

    @Override
    public String toString() {
        return "ID: " +
                '\'' + id + '\'' +
                " ".repeat(5 - String.valueOf(id).length()) +
                "Produto: " +
                '\'' + name + '\'' +
                " ".repeat(30 - name.length()) +
                "Quantidade: " +
                '\'' + amount + '\'' +
                " ".repeat(6 - String.valueOf(amount).length()) +
                "Custo por unidade: " +
                '\'' + String.format("R$ %.2f", cost) + '\'' +
                " ".repeat(7 - String.valueOf(cost).length()) +
                "Preço sugerido: " +
                '\'' + String.format("R$ %.2f", suggestedPrice) + '\'';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    public double getCost() {
        return cost;
    }

    public double getSuggestedPrice() {
        return suggestedPrice;
    }
}

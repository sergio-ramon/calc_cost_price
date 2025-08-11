package calc_cost_price.model;

public class Supply {
    private String name;
    private int packageAmount;
    private int prepareAmount;
    private float prepares;
    private double price;

    public Supply(String name, double price, int packageAmount, int prepareAmount) {
        this.name = name;
        this.packageAmount = packageAmount;
        this.prepareAmount = prepareAmount;
        this.prepares = this.packageAmount / (float) this.prepareAmount;
        this.price = price / prepares;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPackageAmount() {
        return packageAmount;
    }

    public float getPrepares() {
        return prepares;
    }

    @Override
    public String toString() {
        return "| " + name +
                " ".repeat(30 - name.length()) + '|' +
                " R$ " +
                String.format("%.2f", price) +
                "\t| " + prepareAmount + "g" + " ".repeat(5 - String.valueOf(prepareAmount).length()) + "|\n";
    }
}

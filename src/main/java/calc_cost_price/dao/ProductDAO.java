package calc_cost_price.dao;

import calc_cost_price.config.DataBaseConnection;
import calc_cost_price.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO {
    public String create(Product product) {
        String sql = "INSERT INTO product (productName, productAmount, productCost, suggestedPrice) VALUES (?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getAmount());
            stmt.setDouble(3, product.getCost());
            stmt.setDouble(4, product.getSuggestedPrice());
            stmt.executeUpdate();
            return "Novo produto cadastrado com sucesso!";

        } catch (SQLException e) {
            return e.getClass() + " - " + e.getMessage();
        }
    }

    public List<Product> list() {
        String sql = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            try (ResultSet set = stmt.executeQuery()) {
                while (set.next()) {
                    products.add(new Product(set.getLong("id"), set.getString("productName"),
                            set.getInt("productAmount"), set.getDouble("productCost"),
                            set.getDouble("suggestedPrice")));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getClass() + " - " + e.getMessage());
        }

        return products;
    }

    public Product find(Long id) {
        Optional<Product> product = list().stream().
                filter(p -> p.getId().equals(id)).findFirst();

        return product.orElse(null);
    }

    public String delete(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";

        if(list().stream().noneMatch(p -> p.getId().equals(id))) {
            return "Produto com id " + id + " não localizado";
        }

        try (Connection conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
            return "Produto deletado com sucesso!";

        } catch (SQLException e) {
            return e.getClass() + " - " + e.getMessage();
        }
    }
}

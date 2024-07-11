package kz.itstep.rest2.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", unique = true, nullable = false)
    @NotNull
    @NotEmpty(message = "Product name must not be empty")
    private String productName;
    @Column(name = "price")
    @NotNull
    private Double price;
    @Column(name = "description")
    @NotEmpty
    @NotNull
    private String description;

}

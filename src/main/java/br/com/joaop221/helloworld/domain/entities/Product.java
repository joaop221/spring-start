package br.com.joaop221.helloworld.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "ProductName", nullable = false, columnDefinition = "nvarchar")
    private String productName;

    @Column(name = "Package", columnDefinition = "nvarchar")
    private String packageName;

    @Column(name = "IsDiscontinued", nullable = false)
    private Boolean isDiscontinued;

    @Column(name = "UnitPrice",  columnDefinition="decimal", precision = 12, scale = 2, nullable = false)
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "SupplierId ", referencedColumnName = "Id", nullable = false)
    private Supplier supplier;
}

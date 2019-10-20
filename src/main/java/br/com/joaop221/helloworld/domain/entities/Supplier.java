package br.com.joaop221.helloworld.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "CompanyName", nullable = false, columnDefinition = "nvarchar")
    private String companyName;

    @Column(name = "ContactName", columnDefinition = "nvarchar")
    private String contactName;

    @Column(name = "ContactTitle", columnDefinition = "nvarchar")
    private String contactTitle;

    @Column(name = "City", columnDefinition = "nvarchar")

    private String city;

    @Column(name = "Country", columnDefinition = "nvarchar")
    private String country;

    @Column(name = "Phone", columnDefinition = "nvarchar")
    private String phone;

    @Column(name = "Fax", columnDefinition = "nvarchar")
    private String fax;
}

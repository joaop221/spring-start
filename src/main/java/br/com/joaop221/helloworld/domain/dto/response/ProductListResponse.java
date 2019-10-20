package br.com.joaop221.helloworld.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse{

    private Integer id;

    private String productName;

    private String packageName;

    private Boolean isDiscontinued;

    private BigDecimal unitPrice;
}

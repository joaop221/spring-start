package br.com.joaop221.helloworld.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ProductCreateRequest", description = "Used a new Product")
public class ProductCreateRequest {

    private Integer supplierId;

    @NotNull(message = "Product Name cannot be null")
    @ApiModelProperty(notes = "Product Name", name = "productName", required = true)
    private String productName;

    @NotNull(message = "Product Package Name cannot be null")
    @ApiModelProperty(notes = "Package Name", name = "packageName", required = true)
    private String packageName;

    @NotNull(message = "Product Unit Price cannot be null")
    @ApiModelProperty(notes = "Product Name", name = "unitPrice", required = true, value = "decimal")
    private BigDecimal unitPrice;

}

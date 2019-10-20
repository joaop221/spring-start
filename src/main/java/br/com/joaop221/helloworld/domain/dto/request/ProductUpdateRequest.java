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
@ApiModel(value = "ProductUpdateRequest", description = "Used to update a Product")
public class ProductUpdateRequest {

    @NotNull(message = "Product Id cannot be null")
    @ApiModelProperty(notes = "Id", name = "productName", required = true)
    private Integer id;

    @ApiModelProperty(notes = "Product Name", name = "productName")
    private String productName;

    @ApiModelProperty(notes = "Package Name", name = "packageName")
    private String packageName;

    @ApiModelProperty(notes = "unit Price", name = "unitPrice", value = "decimal")
    private BigDecimal unitPrice;

    @ApiModelProperty(notes = "is Discontinued", name = "isDiscontinued", value = "decimal")
    private Boolean isDiscontinued;

}

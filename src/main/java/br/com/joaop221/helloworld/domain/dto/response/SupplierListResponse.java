package br.com.joaop221.helloworld.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierListResponse{

    private Integer id;

    private String companyName;

    private String city;

    private String country;

}
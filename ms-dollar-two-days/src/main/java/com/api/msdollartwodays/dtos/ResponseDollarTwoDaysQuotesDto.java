package com.api.msdollartwodays.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDollarTwoDaysQuotesDto {

    private BigDecimal valorCotacaoDataInformada;
    private String dataCotacaoInformada;
    private BigDecimal valorCotacaoDiaUtilAnterior;
    private String dataCotacaoDiaUtilAnterior;

}

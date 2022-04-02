package com.api.msdollartwodays.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDollarQuoteApiDto {

    private BigDecimal cotacaoCompra;
    private String dataHoraCotacao;

}

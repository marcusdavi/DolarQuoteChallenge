package com.api.msdollarquotebcb.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DollarQuoteDto {

    private BigDecimal cotacaoCompra;
    private BigDecimal cotacaoVenda;
    private String dataHoraCotacao;

}

package com.api.msdollartwodays.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDollarQuoteDto {

    private BigDecimal valorCotacaoDataInformada;
    private LocalDate dataCotacaoInformada;
    private BigDecimal valorCotacaoDiaUtilAnterior;
    private LocalDate dataCotacaoDiaUtilAnterior;

}

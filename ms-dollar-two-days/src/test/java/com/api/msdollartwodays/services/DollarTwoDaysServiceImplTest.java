package com.api.msdollartwodays.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.msdollartwodays.dtos.ResponseDollarQuoteApiDto;
import com.api.msdollartwodays.dtos.ResponseDollarTwoDaysQuotesDto;
import com.api.msdollartwodays.services.impl.DollarTwoDaysServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DollarTwoDaysServiceImplTest {

    @InjectMocks
    private DollarTwoDaysServiceImpl service;

    @Mock
    private DollarQuoteApiService bcbService;

    @Test
    public void testOk() {

	ResponseDollarQuoteApiDto dollarEnteredDate = new ResponseDollarQuoteApiDto();
	dollarEnteredDate.setCotacaoCompra(BigDecimal.valueOf(5.110));
	dollarEnteredDate.setDataHoraCotacao("2022-04-04 08:00:00.000");

	ResponseDollarQuoteApiDto dollarBeforeDate = new ResponseDollarQuoteApiDto();
	dollarBeforeDate.setCotacaoCompra(BigDecimal.valueOf(5.100));
	dollarBeforeDate.setDataHoraCotacao("2022-04-01 08:00:00.000");

	when(bcbService.getDollarQuoteDay(Mockito.anyString())).thenReturn(dollarEnteredDate)
		.thenReturn(dollarBeforeDate);

	ResponseDollarTwoDaysQuotesDto dollarQuote = service.getDollarQuotes("04/04/2022");

	assertEquals(BigDecimal.valueOf(5.110), dollarQuote.getValorCotacaoDataInformada());
	assertEquals(BigDecimal.valueOf(5.100), dollarQuote.getValorCotacaoDiaUtilAnterior());
    }

    @Test
    public void testDateTimeParseError() {

	assertThrows(DateTimeParseException.class, () -> service.getDollarQuotes("01-20-2150"));

    }

}

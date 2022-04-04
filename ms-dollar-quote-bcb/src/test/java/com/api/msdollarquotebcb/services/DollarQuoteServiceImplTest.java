package com.api.msdollarquotebcb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.api.msdollarquotebcb.dtos.DollarQuoteDto;
import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;
import com.api.msdollarquotebcb.exception.NotBusinessDayException;
import com.api.msdollarquotebcb.exception.TodayOrFutureException;
import com.api.msdollarquotebcb.services.impl.BcbServiceImpl;
import com.api.msdollarquotebcb.services.impl.DollarQuoteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DollarQuoteServiceImplTest {

    @InjectMocks
    private DollarQuoteServiceImpl service;

    @Mock
    private BcbServiceImpl bcbService;

    @Test
    public void testOk() {

	DollarQuoteDto dollar = new DollarQuoteDto();
	dollar.setCotacaoCompra(BigDecimal.valueOf(5.110));

	ResponseApiBcbDollarQuoteDto quoteApi = new ResponseApiBcbDollarQuoteDto();
	List<DollarQuoteDto> dollarQuotes = new ArrayList<>();
	dollarQuotes.add(dollar);
	quoteApi.setQuote(dollarQuotes);
	when(bcbService.getCotacaoDolarDia(Mockito.anyString())).thenReturn(quoteApi);

	DollarQuoteDto dollarQuote = service.getDollarQuote("04-01-2020");

	assertEquals(BigDecimal.valueOf(5.110), dollarQuote.getCotacaoCompra());
    }

    @Test
    public void testNotBusinessDayError() {

	ResponseApiBcbDollarQuoteDto quoteApi = new ResponseApiBcbDollarQuoteDto();

	when(bcbService.getCotacaoDolarDia(Mockito.anyString())).thenReturn(quoteApi);

	assertThrows(NotBusinessDayException.class, () -> service.getDollarQuote("01-01-2020"));

    }

    @Test
    public void testTodayOrFutureError() {

	assertThrows(TodayOrFutureException.class, () -> service.getDollarQuote("01-01-2150"));

    }
    
    @Test
    public void testDateTimeParseError() {

	assertThrows(DateTimeParseException.class, () -> service.getDollarQuote("01/20/2150"));

    }
}

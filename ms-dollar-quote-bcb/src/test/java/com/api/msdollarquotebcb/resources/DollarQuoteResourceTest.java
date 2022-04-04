package com.api.msdollarquotebcb.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.api.msdollarquotebcb.dtos.DollarQuoteDto;
import com.api.msdollarquotebcb.services.DollarQuoteService;

@ExtendWith(MockitoExtension.class)
public class DollarQuoteResourceTest {

    @InjectMocks
    private DollarQuoteResource controller;

    @Mock
    private DollarQuoteService service;

    @Test
    public void testOk() {
	DollarQuoteDto dollar = new DollarQuoteDto();
	dollar.setCotacaoCompra(BigDecimal.valueOf(5.110));

	when(service.getDollarQuote(Mockito.any())).thenReturn(dollar);

	ResponseEntity<DollarQuoteDto> response = controller.findQuote("04-01-2022");

	assertEquals(BigDecimal.valueOf(5.110), response.getBody().getCotacaoCompra());
    }
}

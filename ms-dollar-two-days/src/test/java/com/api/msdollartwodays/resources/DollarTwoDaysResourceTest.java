package com.api.msdollartwodays.resources;

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

import com.api.msdollartwodays.dtos.ResponseDollarTwoDaysQuotesDto;
import com.api.msdollartwodays.services.DollarTwoDaysService;

@ExtendWith(MockitoExtension.class)
public class DollarTwoDaysResourceTest {

    @InjectMocks
    private DollarTwoDaysResource controller;

    @Mock
    private DollarTwoDaysService service;

    @Test
    public void testOk() {
	ResponseDollarTwoDaysQuotesDto dollar = new ResponseDollarTwoDaysQuotesDto();
	dollar.setValorCotacaoDataInformada(BigDecimal.valueOf(5.110));

	when(service.getDollarQuotes(Mockito.any())).thenReturn(dollar);

	ResponseEntity<ResponseDollarTwoDaysQuotesDto> response = controller.getQuotes("25/01/2020");

	assertEquals(BigDecimal.valueOf(5.110), response.getBody().getValorCotacaoDataInformada());
    }
}

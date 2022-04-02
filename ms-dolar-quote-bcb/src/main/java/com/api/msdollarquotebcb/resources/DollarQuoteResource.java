package com.api.msdollarquotebcb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.msdollarquotebcb.dtos.ResponseApiBcbDollarQuoteDto;
import com.api.msdollarquotebcb.services.DollarQuoteService;

@RestController
@RequestMapping("/dollar-quotes")
public class DollarQuoteResource {

    @Autowired
    DollarQuoteService service;

    @GetMapping
    public ResponseEntity<ResponseApiBcbDollarQuoteDto> findQuote(@RequestParam String dateForm) {
	return ResponseEntity.ok(service.getDollarQuotes(dateForm));
    }

}

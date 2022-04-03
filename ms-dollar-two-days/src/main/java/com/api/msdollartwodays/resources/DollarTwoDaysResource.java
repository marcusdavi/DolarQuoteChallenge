package com.api.msdollartwodays.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.msdollartwodays.dtos.ResponseDollarTwoDaysQuotesDto;
import com.api.msdollartwodays.services.DollarTwoDaysService;

@RestController
@RequestMapping("/dollar-two")
public class DollarTwoDaysResource {

    @Autowired
    DollarTwoDaysService service;

    @GetMapping
    public ResponseEntity<ResponseDollarTwoDaysQuotesDto> getQuotes(@RequestParam String dateForm) {
	return ResponseEntity.ok(service.getDollarQuotes(dateForm));
    }

}

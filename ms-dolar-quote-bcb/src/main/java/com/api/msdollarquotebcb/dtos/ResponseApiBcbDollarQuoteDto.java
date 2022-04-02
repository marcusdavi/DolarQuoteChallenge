package com.api.msdollarquotebcb.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseApiBcbDollarQuoteDto {

    @JsonAlias({ "value" })
    List<DollarQuoteDto> quote;
}

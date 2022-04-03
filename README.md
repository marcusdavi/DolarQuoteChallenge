# DolarQuoteChallenge

## 1. Stack

1. Java 8
2. Spring Boot
3. Junit
4. Mockito
5. Docker

## 2. Soluction
<p align="center">
  <img src="/solution.png">
</p>

## 3. Validation Rules
The date entered must (Ms Dollar TwoDays):

1. be in dd/MM/yyyy format
2. be a business day
3. be a date before the current day, as API it does not always have the current day's quote.

## 2. URLs
* **Swagger**
 1. Ms Dollar TwoDays -> http://localhost:8081/swagger-ui.html
 2. Ms Dollar Quote API -> http://localhost:8082/ms-dollar-quote-api/swagger-ui.html

* Obs: The API swagger was made available for testing during development. 
* Obs: For testing the final application, use the Ms Dollar Two Days swagger

## 3. Running 
1. Clone repository.
2. Access folder project ms-dollar-quote-bcb and generate jar --> Maven Build: clean package
3. Access folder project ms-dollar-two-days and generate jar --> Maven Build: clean package
4. in Terminal:
```
commands Docker very soon
```
5. Access Swagger
6. Request Endpoint

## 4. Response
```
{
  "dataCotacaoDiaUtilAnterior": "string",
  "dataCotacaoInformada": "string",
  "valorCotacaoDataInformada": 0,
  "valorCotacaoDiaUtilAnterior": 0
}
```
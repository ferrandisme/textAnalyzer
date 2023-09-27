# Text analyzer

This small project aims to provide endpoints for sentiment and language analysis. 

Sentiment analysis will receive a text, which will be split into sentences. The response will be each sentence with its sentiment (neutral, negative, positive, or others). The project uses Stanford Corenlp for data processing. 

Language detection will use a trained model to get information about the language. It will return the three better matches for each text.

## API Reference

#### Get sentiments of a text

```http
  POST /v1/analysis
```

| Parameter | Type     | Description                      |
| :-------- | :------- | :------------------------------- |
| `data`    | `string` | **Required**. Message to analyze |


#### Get langauge of a text

```http
  POST /v1/language
```

| Parameter | Type     | Description                   |
| :-------- | :------- | :---------------------------- |
| `request` | `string` | **Required**. Text to analyze |



## Usage/Examples

```cURL 
curl --location 'localhost:8080/v1/analysis' \
--header 'Content-Type: text/plain' \
--data 'Absolutely love this product! It exceeded my expectations in every way. The quality is top-notch, and it'\''s so easy to use. I can'\''t imagine my life without it now. Highly recommended!'
```
```cURL 
curl --location 'localhost:8080/v1/analysis' \
--header 'Content-Type: text/plain' \
--data 'I bought this product, and it'\''s been nothing but trouble from day one. It'\''s flimsy, breaks easily, and doesn'\''t work as advertised. Save your money and avoid this disappointment.'
```
```cURL 
curl --location 'localhost:8080/v1/language' \
--header 'Content-Type: text/plain' \
--request 'Hola soy Adrian, encantado de conocerte.'
```



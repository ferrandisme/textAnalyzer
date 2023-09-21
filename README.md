# Text analyzer

This small project aims to provide an endpoint for sentiment analysis. This endpoint will receive a text, which will be split into sentences. The response will be each sentence with its sentiment (neutral, negative, positive, or others). The project uses Stanford Corenlp for data processing. Also, this project is an example to practice Kotlin with Spring.


## API Reference

#### Send a message

```http
  POST /v1/analysis
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `data`    | `string` | **Required**. Message to analyze |



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



## Roadmap

- Add data storage in MongoDB Using webflux

- Add other kinds of anylisis (Using other features of the AI)


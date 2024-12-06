# ActiveQM Producer 
## Projeto de teste para envio de mensagens para uma fila do ActiveMQ


```

# Para rodar o ActiveMQ no Docker 
    docker run -d --name activemq-artemis \
        -p 61616:61616 \
        -p 8161:8161 \
        -p 5672:5672 \
        -p 1883:1883 \
        -p 61613:61613 \
        -e ARTEMIS_USERNAME=admin \
        -e ARTEMIS_PASSWORD=iaMuhgNJuViEey9 \
        apache/activemq-artemis


# Para acessar o ActiveMQ
http://localhost:8161/admin
user: artemis
password: iaMuhgNJuViEey9


# Build do projeto
mvn clean install

# Para rodar o projeto
mvn spring-boot:run


# Testar pelo método POST
curl -X POST "http://localhost:8083/produce" -H "Content-Type: text/plain" -d "Hello World!"
curl -X POST "http://localhost:8083/produce" -H "Content-Type: text/plain" -d "Hello World do Producer!"








# Para enviar uma mensagem
curl -X POST http://localhost:8083/send -H "Content-Type: application/json" -d '{"message": "Hello World"}'


# Testar pelo método GET 
# no curl 
curl -X GET "http://localhost:8080/produce?message=Hello%20from%20CURL!"
# no browser
http://localhost:8080/produce?message=Hello%20from%20BROWSER!



```
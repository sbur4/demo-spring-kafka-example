1. run spring
2. send in postman POST => http://localhost:8080/send?message=Hello_Kafka
3. docker:
- found kafka(apache/kafka:latest) in docker hub and pull. run with port 9092
- found kafka(obsidiandynamics/kafdrop:latest) in docker hub and pull. run with port 9000

# Create the network
docker network create kafka-network

# Run Kafka and attach to `kafka-network`
docker run -d --network kafka-network --name my-kafka \
-e KAFKA_CFG_ZOOKEEPER_CONNECT=my-zookeeper:2181 \
-e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://my-kafka:9092 \
apache/kafka:latest

[//]: # (bitnami/kafka)

# Run Kafdrop and attach to `kafka-network`
docker run -d --network kafka-network -p 9000:9000 \
-e KAFKA_BROKERCONNECT=my-kafka:9092 \
obsidiandynamics/kafdrop:latest

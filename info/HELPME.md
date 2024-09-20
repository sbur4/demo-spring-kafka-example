1. Docker:
- image-> apache/kafka:latest
- port-> 9092:9092

2. Docker:
- image-> obsidiandynamics/kafdrop:latest
- port-> 9000:9000
- http://localhost:9000/zipkin/

[//]: # (3. Docker:)

[//]: # (- image-> zookeeper:latest)

[//]: # (- port-> 2181:2181)

[//]: # (- http://localhost:9000/zipkin/)

4. How to run:
   + Application run as debug
   - gradle build -x test
   - in git bash ./gradlew build -x test
   - 
5. http://localhost:8080/send?message=abc
6. http://localhost:8080/sendAndReceive?message=abc

-------------------------------------------------------

[//]: # (docker network create kafka-network)

[//]: # ()
[//]: # (docker run -d --network kafka-network --name my-kafka `)

[//]: # (-e KAFKA_CFG_ZOOKEEPER_CONNECT=my-zookeeper:2181 `)

[//]: # (-e KAFKA_CFG_ADVERTISED_LISTENERS=PLAINTEXT://my-kafka:9092 `)

[//]: # (apache/kafka:latest)

[//]: # ()
[//]: # (docker run -d --network kafka-network -p 9000:9000 -e KAFKA_BROKERCONNECT=my-kafka:9092 obsidiandynamics/kafdrop:latest)

DIAL--------------------------------
docker run --name some-zookeeper --restart always -p 2181:2181 zookeeper
docker run -p 9092:9092 --name kafka -e KAFKA_CFG_ZOOKEEPER_CONNECT=zk:2181 -e ALLOW_PLAINTEXT_LISTENER=yes bitnami/kafka:latest
docker run -p 8080:8080 --name kafka-ui -e KAFKA_CLUSTERS_0_NAME=local -e KAFKA_CLUSTERS_0_BOOTSTRAPSERVERS=localhost:9092 provectuslabs/kafka-ui:latest

---------
start docker kafka on port 9092
run in debug app

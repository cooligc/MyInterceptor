# Kafka Actions

## Start zookeeper

``sh
$bin/zookeeper-server-start.sh config/zookeeper.properties
``

## Start the kafka server

``sh
$bin/kafka-server-start.sh config/server.properties
``

## Create kafka topic 
``sh
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic hello-topic
``

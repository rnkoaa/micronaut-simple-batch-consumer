package io.richard.micronaut.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;

@KafkaListener(
        batch = true,
        offsetReset = OffsetReset.EARLIEST,
        groupId = "simple-change-request-consumer-007"
)
public class ChangeRequestConsumer {

    @Topic("change-requests-v1")
    public void receive(
            List<ConsumerRecord<String, byte[]>> consumerRecords
    ) {
        System.out.printf("Received %d Consumer Records %n", consumerRecords.size());
//        System.out.println();

        consumerRecords.forEach(consumerRecord -> {
            System.out.println("Body: " + new String(consumerRecord.value()));
            System.out.println("Key: " + consumerRecord.key());
            System.out.println("Offset: " + consumerRecord.offset());
            System.out.println("Topic: " + consumerRecord.topic());
            System.out.println("Partition: " + consumerRecord.partition());
            consumerRecord.headers().forEach(header -> {
                System.out.println("Header Key: " + header.key() + ", value: " + new String(header.value()));
            });
            System.out.println("Partition: " + consumerRecord.partition());
            System.out.println("---------------------");
        });
    }

}

record ChangeRequest(String name, String change) {
}

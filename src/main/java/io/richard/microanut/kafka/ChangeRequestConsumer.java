package io.richard.micronaut.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;

@KafkaListener(
        batch = true,
        offsetReset = OffsetReset.EARLIEST,
        groupId = "simple-change-request-consumer-001"
)
public class ChangeRequestConsumer {

    @Topic("change-requests-v1")
    public void receive(
            List<ConsumerRecord<String, byte[]>> consumerRecords
    ) {
        System.out.printf("Received %d Consumer Records %n", consumerRecords.size());
    }

}

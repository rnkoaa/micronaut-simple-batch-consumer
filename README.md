## Micronaut 3.9.0-SNAPSHOT

Testing PR [#598](https://github.com/micronaut-projects/micronaut-kafka/pull/598) with Current Snapshot 3.9.0-SNAPSHOT

```sh 
Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.apache.kafka.clients.consumer.ConsumerRecord` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
 at [Source: (byte[])"{"door": "123","location": "abcd","destination": "9987"}"; line: 1, column: 2]
Caused by: io.micronaut.core.serialize.exceptions.SerializationException: Error deserializing object from JSON: Cannot construct instance of `org.apache.kafka.clients.consumer.ConsumerRecord` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)

	at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
	at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1909)
	at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:408)
	at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1354)
	at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1420)
	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
	at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
	at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
	at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4730)
	at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3771)
	at io.micronaut.jackson.databind.JacksonDatabindMapper.readValue(JacksonDatabindMapper.java:119)
	at io.micronaut.json.JsonObjectSerializer.deserialize(JsonObjectSerializer.java:68)
	... 18 common frames omitted
11:12:40.630 [pool-2-thread-1] INFO  o.a.k.clients.consumer.KafkaConsumer - [Consumer clientId=simple-batch-consumer-change-request-consumer, groupId=simple-change-request-consumer-001] Seeking to offset 2 for partition change-requests-v1-0
Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.apache.kafka.clients.consumer.ConsumerRecord` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)

11:22:57.666 [pool-2-thread-1] INFO  o.a.k.clients.FetchSessionHandler - [Consumer clientId=simple-batch-consumer-change-request-consumer, groupId=simple-change-request-consumer-001] Error sending fetch request (sessionId=469781664, epoch=837) to node 1:
org.apache.kafka.common.errors.DisconnectException: null
```
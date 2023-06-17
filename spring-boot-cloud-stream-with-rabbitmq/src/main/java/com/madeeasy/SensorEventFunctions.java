package com.madeeasy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class SensorEventFunctions {

    // create a consumer
    @Bean
    public Consumer<SensorEventMessage> logEventReceived() {
        return sensorEventMessage -> log.info("Message received: {}", sensorEventMessage);
    }

    // create a producer
    @Bean
    public Supplier<SensorEventMessage> sensorEventProducer() {
        return () -> new SensorEventMessage("2", Instant.now(), 30.0);
    }

//    output will look like ::
//    2023-06-17T21:22:30.603+05:30  INFO 1648 --- [-CLOUD-STREAM-1] com.madeeasy.SensorEventFunctions        : Message received: SensorEventMessage[sensorId=2, timestampEvent=2023-06-17T15:52:30.596606500Z, degrees=30.0]
//    2023-06-17T21:22:31.617+05:30  INFO 1648 --- [-CLOUD-STREAM-1] com.madeeasy.SensorEventFunctions        : Message received: SensorEventMessage[sensorId=2, timestampEvent=2023-06-17T15:52:31.609061500Z, degrees=30.0]
//    2023-06-17T21:22:32.630+05:30  INFO 1648 --- [-CLOUD-STREAM-1] com.madeeasy.SensorEventFunctions        : Message received: SensorEventMessage[sensorId=2, timestampEvent=2023-06-17T15:52:32.620922800Z, degrees=30.0]

}

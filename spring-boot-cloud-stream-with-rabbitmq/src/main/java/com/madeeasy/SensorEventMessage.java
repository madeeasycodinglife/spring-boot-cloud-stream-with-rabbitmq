package com.madeeasy;

import java.time.Instant;

public record SensorEventMessage(String sensorId,
                                 Instant timestampEvent,
                                 Double degrees) {
}

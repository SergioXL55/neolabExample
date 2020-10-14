package com.service.impl;

import com.service.TrackingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Animal tracking test")
class AnimalTrackingTest {

    private final TrackingService trackingService = new AnimalTracking();

    @BeforeEach
    void setUp() {
    }

    @DisplayName("Try to calculate animal count by loaded rules")
    @Test
    void calculateAnimalCountByRules() {
        trackingService.calculateAnimalsCount();
        assertFalse(trackingService.getAnimalCountResult().isBlank());
    }
}
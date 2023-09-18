package me.ferrandis.textAnalyzer.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class AnalysisServiceTest {

    private lateinit var service: AnalysisService;

    @BeforeEach
    fun setUp() {
        service = AnalysisService();
    }

    @Test
    fun analyze() {
        assertEquals("Negative", service.analyze("I hate this").blockFirst()?.elementAt(0)?.status)
        assertEquals("Positive", service.analyze("I love this").blockFirst()?.elementAt(0)?.status)
        val s = "I dont known. You are cool!. You are horrible person"
        assertEquals("Neutral", service.analyze(s).blockFirst()?.elementAt(0)?.status, service.analyze(s).blockFirst()?.elementAt(0)?.sentence)
        assertEquals("Positive", service.analyze(s).blockFirst()?.elementAt(1)?.status, service.analyze(s).blockFirst()?.elementAt(1)?.sentence)
        assertEquals("Neutral", service.analyze(s).blockFirst()?.elementAt(2)?.status, service.analyze(s).blockFirst()?.elementAt(2)?.sentence)
        assertEquals("Negative", service.analyze(s).blockFirst()?.elementAt(3)?.status, service.analyze(s).blockFirst()?.elementAt(3)?.sentence)
    }
}
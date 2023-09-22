package me.ferrandis.textAnalyzer.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LanguageServiceTest {

    lateinit var service: LanguageService;

    @BeforeEach
    fun prepare() {
        service = LanguageService();
    }

    @Test
    fun getLanguage() {
        assertEquals("spa", service.getLanguage("El sol brilla en el cielo azul").get(0).lang);
        assertEquals("pob", service.getLanguage("O pôr do sol na praia é sempre uma vista deslumbrante").get(0).lang);
        assertEquals("fra", service.getLanguage("La vie est belle").get(0).lang);
        assertEquals("ita", service.getLanguage("La dolce vita").get(0).lang);
        assertEquals("eng", service.getLanguage("Artificial Intelligence is very cool").get(0).lang);
    }

}
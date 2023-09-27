package me.ferrandis.textAnalyzer.service

import me.ferrandis.textAnalyzer.repository.LanguageRepository
import opennlp.tools.langdetect.LanguageDetectorME
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.mockito.Mock

class LanguageServiceTest {

    lateinit var service: LanguageService;

    @Mock
    lateinit var repository: LanguageRepository;

    @Mock
    lateinit var languageDetector: LanguageDetectorME


    @BeforeEach
    fun prepare() {
        service = LanguageService(repository, languageDetector);
    }

    @Test
    @Disabled
    fun getLanguage() {
        /*assertEquals("spa", service.getLanguage("El sol brilla en el cielo azul").blockFirst()?.get(0)?.lang);
        assertEquals("pob", service.getLanguage("O pôr do sol na praia é sempre uma vista deslumbrante").blockFirst()?.get(0)?.lang);
        assertEquals("fra", service.getLanguage("La vie est belle").blockFirst()?.get(0)?.lang);
        assertEquals("ita", service.getLanguage("La dolce vita").blockFirst()?.get(0)?.lang);
        assertEquals("eng", service.getLanguage("Artificial Intelligence is very cool").blockFirst()?.get(0)?.lang);*/
    }

}
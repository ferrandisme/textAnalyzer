package me.ferrandis.textAnalyzer.service

import me.ferrandis.textAnalyzer.model.LanguageData
import me.ferrandis.textAnalyzer.repository.LanguageRepository
import opennlp.tools.langdetect.LanguageDetectorME
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Mono

@SpringBootTest
@ExtendWith(MockitoExtension::class)
class LanguageServiceTest {

    lateinit var service: LanguageService;

    @Mock
    lateinit var repository: LanguageRepository;

    @Autowired
    lateinit var languageDetector: LanguageDetectorME


    @BeforeEach
    fun prepare() {
        service = LanguageService(repository, languageDetector);
    }

    @Test
    fun getLanguage() {
        Mockito.`when`(repository.save(ArgumentMatchers.any())).thenAnswer { invocation ->
            val argument = invocation.getArgument<LanguageData>(0)
            Mono.just(argument)
        }

        assertEquals("spa", service.getLanguage("El sol brilla en el cielo azul").block()?.languages?.get(0)?.lang);
        assertEquals("pob", service.getLanguage("O pôr do sol na praia é sempre uma vista deslumbrante").block()?.languages?.get(0)?.lang);
        assertEquals("fra", service.getLanguage("La vie est belle").block()?.languages?.get(0)?.lang);
        assertEquals("ita", service.getLanguage("La dolce vita").block()?.languages?.get(0)?.lang);
        assertEquals("eng", service.getLanguage("Artificial Intelligence is very cool").block()?.languages?.get(0)?.lang);
    }

}
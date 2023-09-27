package me.ferrandis.textAnalyzer.service

import me.ferrandis.textAnalyzer.model.SentimentAnalysis
import me.ferrandis.textAnalyzer.repository.SentimentRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.anyList
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Flux

@ExtendWith(MockitoExtension::class)
class AnalysisServiceTest {

    private lateinit var service: AnalysisService;

    @Mock
    lateinit var repository: SentimentRepository;

    @BeforeEach
    fun setUp() {
        service = AnalysisService(repository);
    }

    @Test
    fun analyze() {
        //GIVEN
        `when`(repository.saveAll(anyList())).thenAnswer { invocation ->
            val argument = invocation.getArgument<ArrayList<SentimentAnalysis>>(0)
            Flux.fromIterable(argument)
        }
        //THEN
        assertEquals("Negative", service.analyze("I hate this").blockFirst()?.status)
        assertEquals("Positive", service.analyze("I love this").blockFirst()?.status)
    }


    @Test
    fun analyze_text() {
        val s = "I dont known. You are cool!. You are horrible person"

        //GIVEN
        `when`(repository.saveAll(anyList())).thenAnswer { invocation ->
            val arguments = invocation.arguments[0] as List<SentimentAnalysis>
            Flux.fromIterable(arguments)
        }

        val buf: MutableList<SentimentAnalysis> = mutableListOf()

        service.analyze(s)
                .collectList()
                .subscribe { result -> buf.addAll(result) }

        //THEN
        assertEquals("Neutral", buf.elementAt(0).status)
        assertEquals("Positive", buf.elementAt(1).status)
        assertEquals("Neutral", buf.elementAt(2).status)
        assertEquals("Negative", buf.elementAt(3).status)
    }
}
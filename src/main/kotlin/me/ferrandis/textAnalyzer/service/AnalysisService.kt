package me.ferrandis.textAnalyzer.service

import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree
import edu.stanford.nlp.util.CoreMap
import me.ferrandis.textAnalyzer.model.SentimentAnalysis
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.util.*
import java.util.stream.Collectors


@Service
class AnalysisService {
    fun analyze(request: String) = Flux.just(analyzeAndReturn(request));

    private fun convert(sentence: CoreMap): SentimentAnalysis {
        val tree = sentence.get(SentimentAnnotatedTree::class.java)
        return SentimentAnalysis(
                sentence.get(SentimentCoreAnnotations.SentimentClass::class.java),
                RNNCoreAnnotations.getPredictedClass(tree),
                sentence.toString())
    }

    private fun analyzeAndReturn(content: String): List<SentimentAnalysis> {
        val props = Properties()
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment")
        val pipeline = StanfordCoreNLP(props)
        val annotation = pipeline.process(content)
        return annotation.get<List<CoreMap>>(SentencesAnnotation::class.java).stream()
                .map(this::convert)
                .collect(Collectors.toList())
    }

}
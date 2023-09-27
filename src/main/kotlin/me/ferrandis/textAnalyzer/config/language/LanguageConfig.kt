package me.ferrandis.textAnalyzer.config.language

import opennlp.tools.langdetect.LanguageDetectorFactory
import opennlp.tools.langdetect.LanguageDetectorME
import opennlp.tools.langdetect.LanguageDetectorSampleStream
import opennlp.tools.util.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class LanguageConfig {

    @Bean
    fun languageDetector(): LanguageDetectorME {
        val dataIn: InputStreamFactory = MarkableFileInputStreamFactory(
                File("src/main/resources/models/languages.txt"))
        val lineStream: ObjectStream<String> = PlainTextByLineStream(dataIn, "UTF-8")
        val sampleStream = LanguageDetectorSampleStream(lineStream)
        val params = TrainingParameters()
        params.put(TrainingParameters.ITERATIONS_PARAM, 200)
        params.put(TrainingParameters.CUTOFF_PARAM, 10)
        params.put("DataIndexer", "TwoPass")
        params.put(TrainingParameters.ALGORITHM_PARAM, "NAIVEBAYES")

        return LanguageDetectorME(LanguageDetectorME
                .train(sampleStream, params, LanguageDetectorFactory()))
    }

}
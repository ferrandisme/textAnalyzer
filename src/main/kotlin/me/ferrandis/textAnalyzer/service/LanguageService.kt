package me.ferrandis.textAnalyzer.service

import opennlp.tools.langdetect.*
import opennlp.tools.util.*
import org.springframework.stereotype.Service
import java.io.File

@Service
class LanguageService {

    fun getLanguage(text: String): List<Language> {
        val dataIn: InputStreamFactory = MarkableFileInputStreamFactory(
                File("src/main/resources/models/languages.txt"))
        val lineStream: ObjectStream<String> = PlainTextByLineStream(dataIn, "UTF-8")
        val sampleStream = LanguageDetectorSampleStream(lineStream)
        val params = TrainingParameters()
        params.put(TrainingParameters.ITERATIONS_PARAM, 200)
        params.put(TrainingParameters.CUTOFF_PARAM, 10)
        params.put("DataIndexer", "TwoPass")
        params.put(TrainingParameters.ALGORITHM_PARAM, "NAIVEBAYES")

        val model = LanguageDetectorME
                .train(sampleStream, params, LanguageDetectorFactory())

        val ld: LanguageDetector = LanguageDetectorME(model)
        return ld
                .predictLanguages(text).toList()
    }
}
package me.ferrandis.textAnalyzer.service

import me.ferrandis.textAnalyzer.model.LanguageData
import me.ferrandis.textAnalyzer.repository.LanguageRepository
import opennlp.tools.langdetect.LanguageDetectorME
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class LanguageService(var repository: LanguageRepository, var languageDetector: LanguageDetectorME) {

    fun getLanguage(text: String): Mono<LanguageData> {
        val languages = languageDetector
                .predictLanguages(text).toList()
        return repository.save(LanguageData(languages.take(3), text))
    }
}
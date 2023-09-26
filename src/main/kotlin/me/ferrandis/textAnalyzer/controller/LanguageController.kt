package me.ferrandis.textAnalyzer.controller

import me.ferrandis.textAnalyzer.service.LanguageService
import opennlp.tools.langdetect.Language
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class LanguageController(var service: LanguageService) {

    @PostMapping("v1/language")
    fun dataAnalysis(@RequestBody request: String): Flux<List<Language>> {
        return service.getLanguage(request);
    }
}


package me.ferrandis.textAnalyzer.controller

import me.ferrandis.textAnalyzer.model.LanguageData
import me.ferrandis.textAnalyzer.service.LanguageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class LanguageController(var service: LanguageService) {

    @PostMapping("v1/language")
    fun dataAnalysis(@RequestBody request: String): Mono<LanguageData> {
        return service.getLanguage(request);
    }
}


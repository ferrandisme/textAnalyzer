package me.ferrandis.textAnalyzer.controller

import me.ferrandis.textAnalyzer.model.SentimentAnalysis
import me.ferrandis.textAnalyzer.service.AnalysisService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
class AnalysisController(var service: AnalysisService) {

    @PostMapping("v1/analysis")
    fun dataAnalysis(@RequestBody request: String): Flux<SentimentAnalysis> {
        return service.analyze(request);
    }
}


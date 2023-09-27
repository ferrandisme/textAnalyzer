package me.ferrandis.textAnalyzer.repository

import me.ferrandis.textAnalyzer.model.SentimentAnalysis
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface SentimentRepository : ReactiveCrudRepository<SentimentAnalysis, Long> {
}
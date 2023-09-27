package me.ferrandis.textAnalyzer.repository

import me.ferrandis.textAnalyzer.model.SentimentAnalysis
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SentimentRepository : ReactiveCrudRepository<SentimentAnalysis, Long> {
}
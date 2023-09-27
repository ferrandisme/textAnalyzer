package me.ferrandis.textAnalyzer.repository

import me.ferrandis.textAnalyzer.model.LanguageData
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface LanguageRepository : ReactiveCrudRepository<LanguageData, Long> {
}
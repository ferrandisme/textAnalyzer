package me.ferrandis.textAnalyzer.repository

import me.ferrandis.textAnalyzer.model.LanguageData
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepository : ReactiveCrudRepository<LanguageData, Long> {
}
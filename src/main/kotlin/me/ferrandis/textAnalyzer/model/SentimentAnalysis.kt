package me.ferrandis.textAnalyzer.model

@JvmRecord
data class SentimentAnalysis(val status: String, val value: Int, val sentence: String)
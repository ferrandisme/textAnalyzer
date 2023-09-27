package me.ferrandis.textAnalyzer.model

import opennlp.tools.langdetect.Language

@JvmRecord
data class LanguageData(val languages: List<Language>, val text: String)
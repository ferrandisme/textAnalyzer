package me.ferrandis.textAnalyzer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TextAnalyzerApplication

fun main(args: Array<String>) {
	runApplication<TextAnalyzerApplication>(*args)
	println("\n\n--------------------------\nRUNNING!\n--------------------------")
}

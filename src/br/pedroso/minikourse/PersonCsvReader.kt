package br.pedroso.minikourse

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object PersonCsvReader {
    private const val RESOURCE_NAME = "/pessoas.csv"
    private const val MARRIED_STRING = "casado"
    private const val SINGLE_STRING = "solteiro"
    private const val WIDOWED_STRING = "viúvo"
    private const val DIVORCED_STRING = "divorciado"


    private fun getFileContent(): String {
        return String::class.java.getResource(RESOURCE_NAME).readText()
    }

    fun getPeopleFromFile(): List<Person> {
        val people = mutableListOf<Person>()

        val fileContent = getFileContent()

        val lines = fileContent.split("\n")

        lines
                .map { it.split(",") }
                .filter { !(it.any { it.trim().isBlank() || it.trim().isEmpty() }) }
                .map { parseLineValues(it) }
                .forEach { people += it }

        return listOf(*people.toTypedArray())
    }

    private fun parseLineValues(values: List<String>): Person {
        return Person(values[0],
                values[1],
                parseDate(values[2]),
                values[3],
                values[4],
                parseMaritalStatus(values[5]))
    }

    private fun parseMaritalStatus(maritalStatusString: String) = when (maritalStatusString.toLowerCase()) {
        MARRIED_STRING -> MaritalStatus.MARRIED
        SINGLE_STRING -> MaritalStatus.SINGLE
        WIDOWED_STRING -> MaritalStatus.WIDOWED
        DIVORCED_STRING -> MaritalStatus.DIVORCED
        else -> MaritalStatus.UNKNOWN
    }


    private fun parseDate(dateString: String): LocalDate {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return LocalDate.parse(dateString, dateTimeFormatter)
    }
}
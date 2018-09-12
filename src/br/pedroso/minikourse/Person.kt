package br.pedroso.minikourse

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

data class Person(
        val name: String,
        val surname: String,
        val birthDate: LocalDate,
        val city: String,
        val state: String,
        val maritalStatus: MaritalStatus) {

    val age: Int
        get() = Period.between(birthDate, LocalDate.now()).years

    val formattedDate: String
        get() {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            return birthDate.format(formatter)
        }
}

enum class MaritalStatus {
    SINGLE, MARRIED, DIVORCED, WIDOWED, UNKNOWN
}
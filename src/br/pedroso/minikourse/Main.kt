package br.pedroso.minikourse

fun main(args: Array<String>) {
    val people = PersonCsvReader.getPeopleFromFile()

    people
            .sortedBy { it.age }
            .forEach {
                with(it) {
                    println("$name - $age")
                }
            }
}
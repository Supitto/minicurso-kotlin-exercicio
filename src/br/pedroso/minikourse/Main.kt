package br.pedroso.minikourse

fun main(args: Array<String>) {
    val people = PersonCsvReader.getPeopleFromFile()

    people
            .sortedWith(compareBy({ it.age }, { it.name }))
            .forEach {
                with(it) {
                    println("$name - $age")
                }
            }
}
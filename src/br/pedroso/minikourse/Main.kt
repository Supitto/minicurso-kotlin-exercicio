//Codigo orgianal por Felipe Pedroso
//Resolução de exercicios por Henrique Marcomini

package br.pedroso.minikourse

fun main(args: Array<String>) {
    val people = PersonCsvReader.getPeopleFromFile()

   /*people
            .sortedWith(compareBy({ it.age }, { it.name }))
            .forEach {
                with(it) {
                    println("$name - $maritalStatus")
                }
            }
    */
    //Encontrar as pessoas mais velhas de cada estado

    println("Exercicio 1\n\n")

    //Primeiro separamos elas por estado
    people.groupBy(Person::state).forEach<String, List<Person>>
    {
        //Imprimimos o nome do estado
        println("${it.key} - " +
                //Escolhemo o maior item da coleção baseado na idade
                "${it.value.maxBy{ it.age }
                        //E extraimos o nome (O NOME É NULLABLE)
                        ?.name
                }"
        )
    }
    //Calcular a distribuição de pessoas de acordo com o estado civil

    println("\n\nExercicio 2\n\n")

    //Por conveniencia vamos guardar o total de pessoas
    val countPeople = people.count().toFloat()

    //Agora basta imprimir o total de pessoas
    println("Total - $countPeople")

    //Como o $ é equivalente a um eval, podemos incluir as
    //operações diretamente na string
    //Utilizamos o filtro para separa os status
    //Tambem poderia ser feira uma lista, oque diminuiria em 4 vezes o
    //tempo de processamento, porem aumentaria o consumo de memoria
    println("Casados - ${people.filter {it.maritalStatus.equals(MaritalStatus.MARRIED) }.count().toFloat().div(countPeople)*100}%")
    println("Solteiros - ${people.filter {it.maritalStatus.equals(MaritalStatus.SINGLE) }.count().toFloat().div(countPeople)*100}%")
    println("Divorciado - ${people.filter {it.maritalStatus.equals(MaritalStatus.DIVORCED) }.count().toFloat().div(countPeople)*100}%")
    println("Viuvos - ${people.filter {it.maritalStatus.equals(MaritalStatus.WIDOWED) }.count().toFloat().div(countPeople)*100}%\n")


    println("\n\nExercicio 3\n\n")

    //Primeiro ordenamos a coleção por idade
    people.sortedBy { it.age }
            //Depois para cada pessoa, imprimimos a idade
            .forEach {
                with(it)
                {
                    println("$name - $age")
                }
            }

    println("\n\nExercicio 4\n\n")

    //Esse é uma variação do primeiro exercicio
    people.groupBy { it.state }
            .forEach{
                println("${it.key} - ${it.value.count()}")
            }

    println("\n\nExercicio Surpresa\n\n")


}
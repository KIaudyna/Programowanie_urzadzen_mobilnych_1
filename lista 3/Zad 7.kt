fun srt(lista:List<String>): List<Pair<String,List <String>>>{
    val wynik = lista
        .filter{it.length % 2 == 0}
        .groupBy{it.first().toString()}
        .map{it.key to it.value}
        .sortedBy{it.first}
    return wynik
}

//-----------------------------wywolanie
fun main(){
    val lista = listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")
    println(srt(lista))
}
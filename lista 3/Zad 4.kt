fun countElements(lista:List<List<String>>): Map<String, Int>{
    val splaszcona = lista.flatten()
    val wynik = splaszcona.groupingBy{it}.eachCount()
    return wynik
}

//------------------------------wywolanie
fun main(){
    val lista = listOf(listOf("a", "b", "c"), listOf("c", "d", "f"), listOf("d", "f", "g"))
    println(countElements(lista))
}
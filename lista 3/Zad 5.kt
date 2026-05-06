fun evenPositiveSquare(lista: List<Int>): List<Int>{
    val wynik = lista
        .withIndex()
        .filter{it.value > 0 && it.index %2 != 0}
        .map{it.value * it.value}
    return wynik
}

fun main(){
    val lista = listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)
    println(evenPositiveSquare(lista))
}
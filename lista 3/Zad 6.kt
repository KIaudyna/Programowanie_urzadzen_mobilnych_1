fun perm(lista: List<Int>): List<List<Int>> {
    if (lista.size <= 1) return listOf(lista)

    return lista.flatMap {element -> val reszta = lista - element
        perm(reszta).map{permutacja -> listOf(element) + permutacja}
    }
}
//-------------------------------wywolanie
fun main(){
    val lista = listOf(1, 2, 3)
    println(perm(lista))
}

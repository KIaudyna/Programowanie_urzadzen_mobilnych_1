fun suma(a: List<Int>): Int{
    val lista = a
    .filter{it > 0}
    .sum()

    return lista
}
//---------------------------------------------wywolanie
fun main(){
    val lista = listOf( 1, -4, 12, 0, -3, 29, -150)
    println(suma(lista))

}
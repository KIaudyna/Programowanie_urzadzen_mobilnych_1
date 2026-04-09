//wydobycie 1 pozycji
val <T> List<T>.head: T
    get() = this.first()

//usunięcie 1 pozycji
val <T> List<T>.tail: List<T>
    get() = this.drop(1)

fun main(){
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.head)
    println(numbers.tail)
}
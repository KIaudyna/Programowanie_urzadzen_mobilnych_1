

fun <A> isSorted(lst: List<A>, order: (A,A) -> Boolean): Boolean{
    for(i in 0 until lst.size-1){
        val a = lst[i]
        val b = lst[i+1]

        if(!order(a,b)){
            return false
        }
    }
    return true
}

fun main(){
    val listaPosortowana = listOf(1, 2, 3, 4, 5)
    val listaNieposortowana = listOf(4, 3, 6, 1)

    println("Lista (1, 2, 3, 4, 5): " + isSorted(listaPosortowana, {i: Int, j: Int -> i < j}))
    println("Lista (4, 3, 6, 1): " + isSorted(listaNieposortowana, {i: Int, j: Int -> i < j}))
}
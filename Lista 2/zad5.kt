fun check(N: Int, lst: List<Int>): Int{
    for(i in 0 until lst.size-N){
        val preambula = lst.subList(i, i + N)
        var znaleziona = false

        for(x in preambula){
            for(y in preambula){
                if(x != y && x+y == lst[i + N]){
                    znaleziona = true
                    break
                }
            }
            if(znaleziona){
                break
            }
        }
        if(!znaleziona){
            return lst[i + N]
        }
    }
    return 0
}

fun main(){
    val lista = listOf(1, 2, 3, 5, 7, 12, 30)
    println(lista)
    println(check(3, lista))
}
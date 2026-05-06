fun findDuplicates(lst: List<Int>): List<Int> {
    val duplikaty = mutableSetOf<Int>()
    val juzByly = mutableSetOf<Int>()

    for(i in lst){
        if(!juzByly.add(i)){
            duplikaty.add(i)
        }
    }
    return duplikaty.sorted()
}

//--------------------------------------------------------------------wywolanie
fun main(){
    val lst = listOf(0, 1, 1, 1, 4, 4, 4, 9, 3, 3, 3, 3, 3, 3)
    println(findDuplicates(lst))
}
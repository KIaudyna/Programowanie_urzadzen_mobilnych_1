fun addToBoolean(N: Int): Map<Int, Boolean>{
    val koncowa = mutableMapOf<Int, Boolean>()
    for(i in 1..N){
        koncowa[i] = i%2==0
    }
    return koncowa
}

//-----------------------------------------wywolanie
fun main(){
    println(addToBoolean(20))
}
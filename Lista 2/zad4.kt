fun safePareAndClassify(input: String?): String{
    val liczba = input?.toIntOrNull()
    if(liczba == null){
        return "BRAK_DANYCH"
    }
    if(liczba % 2 == 0){
        return "PARZYSTA"
    }else{
        return "NIEPARZYSTA"
    }
}

fun main(){
    println("'1': " + safePareAndClassify("1"))
    println("'2': " + safePareAndClassify("2"))
    println("'kot': " + safePareAndClassify("kot"))
    println("null: " + safePareAndClassify(null))
    println("'': " + safePareAndClassify(""))
}
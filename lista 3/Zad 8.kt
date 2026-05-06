fun convert(slowo: String): String{
    val tekst = slowo.lowercase()
    val mapa = mapOf(
        'a' to "2",
        'b' to "22",
        'c' to "222",
        'd' to "3",
        'e' to "33",
        'f' to "333",
        'g' to "4",
        'h' to "44",
        'i' to "444",
        'j' to "5",
        'k' to "55",
        'l' to "555",
        'm' to "6",
        'n' to "66",
        'o' to "666",
        'p' to "7",
        'q' to "77",
        'r' to "777",
        's' to "7777",
        't' to "8",
        'u' to "88",
        'v' to "888",
        'w' to "9",
        'x' to "99",
        'y' to "999",
        'z' to "9999",
    )

    val wynik = tekst
        .map{mapa[it]}
        .joinToString("")

    return wynik
}

//---------------------------------------wywolanie
fun main(){
    val word = "franek"
    println(convert(word))
}
fun wypiszLiczby(ilosc: Int){ 

    for (liczba in 1..ilosc){ 

        if(liczba%3==0 && liczba%5==0){ 

            println("TrzyPiec") 

        }else if(liczba%5==0){ 

            println("Piec") 

        }else if(liczba%3==0){ 

            println("Trzy") 

        }else{ 

        println(liczba)     

        } 

         

    } 

} 

  

fun main() { 

val iloscLiczb = 15 

wypiszLiczby(iloscLiczb) 

} 

   

     

     

     

     


 

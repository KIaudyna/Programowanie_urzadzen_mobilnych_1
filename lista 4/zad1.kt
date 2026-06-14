import kotlin.random.*
import java.time.LocalDate
import java.time.Month

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost (
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)



object DataProvider {
    val generalCosts = List(5) {
        Cost(
            CostType.values()[Random.nextInt(CostType.values().size)],
            LocalDate.of(
                2025,
                Random.nextInt(1,13),
                Random.nextInt(1,28)
            ),
            Random.nextInt(5000)
        )
    }
}



//--------------------------------------------------------------Z1
fun groupedCostMap(costs: List<Cost>): Map<Month, List<Cost>> {
    return costs
        .groupBy{it.date.month}
        .toSortedMap()
}

//--------------------------------------------------------------Z2
fun wszystkieKoszty(costs: List<Cost>): Unit {
    costs
        .groupBy{it.date.month}
        .toSortedMap()
        .forEach{(miesiac, kosztaWMiesiacu) -> println("\n ${miesiac}")
            kosztaWMiesiacu
                .sortedBy{it.date.dayOfMonth}
                .forEach{println("${it.date.dayOfMonth} ${it.type} ${it.amount} zł")}
        }
}

//--------------------------------------------------------------Z3
sealed class MonthlyCostStatus

data object NoCosts : MonthlyCostStatus()
data class WithinLimit(val total: Int): MonthlyCostStatus()
data class OverLimit(val total: Int, val exceededBy: Int): MonthlyCostStatus()

fun classifyMonthlyCosts(costs: List<Cost>, month: Month, limit: Int): MonthlyCostStatus{
    val wybrany = costs.filter{it.date.month == month}
    val suma = wybrany.sumOf{it.amount}

    if(wybrany.isEmpty()){
        return NoCosts
    }

    if(suma > limit){
        return OverLimit(suma, suma-limit)
    }else{
        return WithinLimit(suma)
    }
}

//--------------------------------------------------------------Z4
interface CostFormatter{
    fun format(cost: Cost): String
}

object PlCostFormatter : CostFormatter {
    override fun format(cost: Cost): String {
        return "${cost.date.dayOfMonth} ${cost.type} ${cost.amount} zł"
    }
}


fun formatCosts(costs: List<Cost>, formatter: CostFormatter): String{
    return costs
        .sortedBy{it.date}
        .map {formatter.format(it)}
        .joinToString("\n")
}



fun main() {
    println("---------------------------------------ZAD 1")
    val wynikZ1 = groupedCostMap(DataProvider.generalCosts)
    println(wynikZ1)

    println("---------------------------------------ZAD 2")
    wszystkieKoszty(DataProvider.generalCosts)

    println("---------------------------------------ZAD 3")
    val costs = listOf(
        Cost(CostType.REFUELING, LocalDate.of(2025, 1, 10), 300),
        Cost(CostType.PARKING, LocalDate.of(2025, 1, 12), 50),
        Cost(CostType.SERVICE, LocalDate.of(2025, 2, 4), 1200)
    )

    println(classifyMonthlyCosts(costs, Month.JANUARY, 400))
    println(classifyMonthlyCosts(costs, Month.FEBRUARY, 1000))
    println(classifyMonthlyCosts(costs, Month.MARCH, 500))

    println("---------------------------------------ZAD 4")
    val costsZad4 = listOf(
        Cost(CostType.PARKING, LocalDate.of(2025, 1, 15), 30),
        Cost(CostType.SERVICE, LocalDate.of(2025, 1, 5), 900)
    )

    println(formatCosts(costsZad4, PlCostFormatter))

}

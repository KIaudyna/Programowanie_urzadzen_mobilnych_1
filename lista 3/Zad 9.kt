data class StudentScore(val name: String, val subject: String, val score: Int)

fun analyzeResults(lista: List<StudentScore>): Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>>{
    val passedBySubject = lista
        .filter{it.score >= 50}
        .groupBy{it.subject}

    val failed = lista
        .filter{it.score < 50}

    val subjectsAllPassed = lista
        .groupBy{it.subject}
        .filterValues {students -> students.all {it.score >= 50}}
        .keys
        .toList()


    return Triple(passedBySubject, failed, subjectsAllPassed)
}
//------------------------------------------------------
fun main(){
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )

    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")

}
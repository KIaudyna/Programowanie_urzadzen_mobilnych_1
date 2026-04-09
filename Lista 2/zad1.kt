data class UserInput(val name: String?, val email: String?, val age: String?)
data class UserProfile(
    var name: String = "",
    var email: String = "",
    var age: Int = 0,
    var isAdult: Boolean = false
)

fun buildProfile(input: UserInput?, logs: MutableList<String>): UserProfile? {
//    if (input == null) {
//        logs.add("Input is null")
//        return null
//    }
    input ?: return null.also {logs.add("Input is null")}


//    if (input.name == null) {
//        logs.add("Name is null")
//        return null
//    }
//    val name = input.name.trim()
//    if (name.length < 3) {
//        logs.add("Name too short")
//        return null
//    }

    val name = input.name?.trim()?.let{
        if(it.length<3) return null.also {logs.add("Name too short")}
        it
    }?: return null.also {logs.add("Name is null") }

//    if (input.email == null) {
//        logs.add("Email is null")
//        return null
//    }
//    val email = input.email.trim().lowercase()
//    if (!email.contains("@")) {
//        logs.add("Invalid email")
//        return null
//    }

    val email = input.email?.trim()?.lowercase()?.let{
        if(!it.contains("@")) return null.also { logs.add("Invalid email") }
        it
    }?: return null.also {logs.add("Email is null")}

//    if (input.age == null) {
//        logs.add("Age is null")
//        return null
//    }
//    val age = input.age.toIntOrNull()
//    if (age == null) {
//        logs.add("Age is not a number")
//        return null
//    }
    val age = input.age?.let{
        it.toIntOrNull()?:return null.also{logs.add("Age is not a number")}
    }?: return null.also{logs.add("Age is null")}

//    val age = input.age
//        ?.run { toIntOrNull() }
//        ?: return null.also { logs.add("Age is not a number") }
//
//    val profile = UserProfile()
//    profile.name = name
//    profile.email = email
//    profile.age = age
//    profile.isAdult = age >= 18

//    logs.add("Profile created for $email")
//    return profile
    return UserProfile().apply{
        this.name = name
        this.email = email
        this.age = age
        this.isAdult = age >= 18
    }.also{logs.add("Profile created for $email")}
}

fun main() {
    val logs = mutableListOf<String>()

    val input1 = UserInput(
        name = "Jan Kowalski",
        email = "jan@example.com",
        age = "25"
    )

    val input = UserInput(
        name = "Jaaaaaaa", // za krótkie
        email = "janexample.com",
        age = "70"
    )

    val profile = buildProfile(input, logs)

    println("Profile: $profile")
    println("Logs:")
    logs.forEach { println(it) }
}
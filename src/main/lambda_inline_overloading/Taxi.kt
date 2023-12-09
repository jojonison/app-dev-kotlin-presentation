import java.util.Scanner

data class Taxi(val taxiNumber: String, val baseFare: Double, val perKilometerRate: Double, val quota: Double) {
    var isBooked: Boolean = false

    operator fun plus(otherTaxi: Taxi): Double {
        return this.quota + otherTaxi.quota
    }

    operator fun invoke() {
        if (!isBooked) {
            println("\nTaxi $taxiNumber has been booked. \n")
            isBooked = true
        } else {
            println("\nTaxi $taxiNumber is already booked.\n")
        }
    }


    inline fun calculateFare(distance: Double, fareCalculator: (Double) -> Double): Double {
        return fareCalculator(distance)
    }

    companion object {
        @JvmStatic
        fun main(args:Array<String>) {
            loginUser()
        }
    }
}


val taxis = mutableListOf<Taxi>()

fun printMenuUser() {
    println("\nBaguio City Taxi Booking System")
    println("Welcome to the City of Pines!\n")
    println("1. Book a taxi")
    println("2. Get total quota of all taxis")
    println("3. Exit")
    getUserChoice()
}
fun getUserChoice() {
    val kbd = Scanner(System.`in`)
    println("Enter choice: ")
    val choice = kbd.nextInt()

    when (choice) {
        1 -> bookTaxi()
        2 -> getTotalQuota()
        3 -> println("Thank you for using our program!")
        else -> println("Invalid choice")
    }
}

fun loginUser() {
    val taxi1 = Taxi("T123", 40.0, 13.0, 100.00)
    val taxi2 = Taxi("T456", 40.0, 15.0, 550.00)

    taxis.addAll(listOf(taxi1, taxi2))

    val credentials = mapOf(
        "" to "",
        "admin" to "admin"
    )
    val kbd = Scanner(System.`in`)

    println("\nLogin to App ")
    println("Username: ")
    val user = kbd.nextLine()
    println("Password: ")
    val pass = kbd.nextLine()

    when {
        credentials[user] == pass -> {
            println("LOGGED IN\n")
            when (user) {
                "" -> printMenuUser()
            }
        }

        else -> println("INVALID CREDENTIALS")
    }
}

fun bookTaxi() {
    println("\nAvailable Taxis in Baguio City: ")
    taxis.forEachIndexed { index, taxi ->
        println("${index + 1}. Taxi ${taxi.taxiNumber}")
    }

    val kbd = Scanner(System.`in`)
    print("Choose a taxi (1-${taxis.size}): ")
    val choice = kbd.nextInt()

    val selectedTaxi = taxis.getOrNull(choice - 1)

    if (selectedTaxi != null && !selectedTaxi.isBooked) {
        selectedTaxi() // call the overloaded method (invoke)
        println("\nKilometers to your destination: ")
        val distanceInKilometers = kbd.nextDouble()

        val fare = selectedTaxi.calculateFare(distanceInKilometers) { distance ->
            selectedTaxi.baseFare + (distance * selectedTaxi.perKilometerRate)
        }

        println("\nTaxi Fare for $distanceInKilometers kilometers for Taxi ${selectedTaxi.taxiNumber}: ₱$fare")

        println("Press enter to continue")
        kbd.nextLine()
        kbd.nextLine()
    } else {
        println("Invalid choice or taxi already booked.")
    }

    printMenuUser()
}


fun getTotalQuota() {
    val kbd = Scanner(System.`in`)
    val totalQuota = taxis[0] + taxis[1]
    println("\nTotal quota for all taxis: ₱$totalQuota")

    println("\nPress enter to continue...")
    kbd.nextLine()
    printMenuUser()
}


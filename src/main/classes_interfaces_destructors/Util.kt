fun giveListOfTouristSpots() : MutableList<TouristSpots> {
    val place1 = TouristSpots("Place1", "Doon", 10)
    val place2 = TouristSpots("Place2", "Diyan", 4)
    val place3 = TouristSpots("Place3", "There", 6)
    val place4 = TouristSpots("Place4", "Diretso ka lang", 0)
    return mutableListOf(place1,place2,place3,place4)
}

fun giveListOfRestaurants() : MutableList<Restaurant> {
    val place1 = Restaurant("Amy's Baking Company", "Di ko alam", "Pizzaria", "Full")
    val place2 = Restaurant("Jollibee", "Sa tabi ng Mcdo", "Fast Food", "Has Vacant Seats")
    val place3 = Restaurant("McDonald's", "Sa tabi ng Jollibee", "Fast Food", "Has Vacant Seats")
    val place4 = Restaurant("Burger King", "SM", "Fast Food", "Full")
    return mutableListOf(place1,place2,place3,place4)
}

fun printLoginChoices(){
    println("""
            Login as:
            1 - Owner
            2 - Guest
            3 - Exit
        """.trimIndent())
}

fun printGuestChoices(){
    println("""
            What to do?
            1 - View tourist spot details
            2 - View restaurant details
            3 - Log Out
        """.trimIndent())
}
fun printOwnerCRUDChoices() {
    println("""
        What to do?:
        1 - View tourist spots' details
        2 - View restaurants' details
        3 - Edit tourist spots' parking vacancies
        4 - Edit restaurants' seating capacity
        5 - Add tourist spot
        6 - Add restaurant
        7 - Remove tourist spot
        8 - Remove restaurant  
        9 - Log Out
    """.trimIndent())
}

fun addTouristSpot() : TouristSpots {
    println("Name: ")
    val name = readln()
    println("Location: ")
    val location = readln()
    println("How many parking spaces?: ")
    val vacant = readln().toInt()
    return TouristSpots(name,location,vacant)
}

fun addRestaurant() : Restaurant {
    println("Name: ")
    val name = readln()
    println("Location: ")
    val location = readln()
    println("Type: ")
    val type = readln()
    println("Seating Capacity Status?: ")
    val capacity = readln()
    return Restaurant(name,location,type, capacity)
}

fun viewTouristSpotsDetails(set: MutableList<TouristSpots>) {
    var num = 1
    for (touristSpot in set) {
        println("Tourist Spot # $num")
        println(touristSpot.toString())
        println()
        num += 1
    }
}

fun viewRestaurantsDetails(set: MutableList<Restaurant>) {
    var num = 1
    for (restaurant in set) {
        println("Restaurant #$num")
        println(restaurant.toString())
        println()
        num += 1
    }
}

fun editTouristSpot(touristSpots: MutableList<TouristSpots>) {
    viewTouristSpotsDetails(touristSpots)
    println("Enter the number of the tourist spot you want to edit: ")
    val indexToBeEdited = readln().toInt()
    println("Enter the new number of vacant parking spaces: ")
    val numVacantParking = readln().toInt()

    if (indexToBeEdited >= 1 && indexToBeEdited <= touristSpots.size) {
        touristSpots[indexToBeEdited - 1].numVacantParking = numVacantParking
    } else {
        println("Invalid choice.")
    }
}

fun editRestaurant(restaurants: MutableList<Restaurant>) {
    viewRestaurantsDetails(restaurants)
    println("Enter the number of the restaurant you want to edit: ")
    val indexToBeEdited = readln().toInt()
    println("Enter the new seating capacity: ")
    val seatingCapacity = readln()

    if (indexToBeEdited >= 1 && indexToBeEdited <= restaurants.size) {
        restaurants[indexToBeEdited - 1].seatingCapacity = seatingCapacity
    } else {
        println("Invalid choice.")
    }
}
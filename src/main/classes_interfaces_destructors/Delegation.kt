interface ShowPlace {
    fun show(placeName: String)
}

class ShowPlaceName : ShowPlace {
    override fun show(placeName: String) {
        println(placeName)
    }
}

open class ShowRestaurantName(private val edit: ShowPlace) : ShowPlace by edit

fun main() {
    val showPlaceName = ShowPlaceName()
    val showRestaurantName = ShowRestaurantName(showPlaceName)

    for (i in restaurantMutableList) {
        showRestaurantName.show(i.name)
    }
}
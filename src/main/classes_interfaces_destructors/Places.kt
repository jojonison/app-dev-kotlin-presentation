open class Place(
    open val name: String,
    open val location: String
) {
    override fun toString(): String {
        return """
            Name of Place:          $name
            Location:               $location
        """.trimIndent()
    }
}

data class TouristSpots(
    override val name: String,
    override val location: String,
    var numVacantParking: Int,
) : Place(name, location) {
    override fun toString(): String {
        return """
            Tourist Spot:           $name
            Location:               $location
            Vacant Parking Space:   $numVacantParking
        """.trimIndent()
    }
}

data class Restaurant(
        override val name: String,
        override val location: String,
        val restaurantType: String,
        var seatingCapacity: String,
) : Place(name, location) {
    override fun toString(): String {
        return """
            Restaurant:             $name
            Location:               $location
            Restaurant Type:        $restaurantType
            Seating Capacity:       $seatingCapacity
        """.trimIndent()
    }
}
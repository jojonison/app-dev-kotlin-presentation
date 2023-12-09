/**
 *
 *  CAR
 *  50 PHP FIRST 3 HOURS
 *
 *
 *  MOTORCYCLE
 *  25 PHP FIRST 3 HOURS
 *
 *
 *  10 PHP per succeeding hour
 */
open class Vehicle(internal var hoursOfStay: Int, var transactionID: String) {
    var tpf: Int = 0

}


/**
 * Car class that extends the Vehicle class
 */
class Car (var plateNumber: String, var parkingFee: Int = 50,  hoursOfStay: Int): Vehicle (hoursOfStay, getRandomID()) {

    var totalParkingFee: Int = computeParkingFee()

    /**
     * Single Expression Function
     */
    private fun computeParkingFee() = (hoursOfStay - 3) * 10 + parkingFee


    override fun toString(): String {
        return "Car\nPlate number: $plateNumber\nHours of stay:${hoursOfStay}\nTotal Parking Fee: $totalParkingFee\nTransaction ID: ${this.transactionID}"
    }
}

/**
 * Motorcycle class that extends the Vehicle class
 */

class Motorcycle (var plateNumber: String, var parkingFee: Int = 25, hoursOfStay: Int): Vehicle(hoursOfStay, getRandomID()) {

    /**
     * Demonstrates Single Expression Function
     */
    var totalParkingFee: Int = computeParkingFee()

    // computation of total parking fee
    // 50 for cars, 35 for motorcycles. + 10 for every succeeding hour
    private fun computeParkingFee() = (hoursOfStay - 3) * 10 + parkingFee

    override fun toString(): String {
        return "Motorcycle\nPlate number: $plateNumber\nHours of stay:${hoursOfStay}\nTotal Parking Fee:$totalParkingFee" +
                "\nTransaction ID: ${this.transactionID}"
    }
}


fun getRandomID(): String {
    val chars = ('A' .. 'Z') + ('a' .. 'z') + ('0' .. '9')
    return (1 .. 12).map {chars.random()}.joinToString("")
}
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.Scanner

/**
 * Counts all Cars in the list
 */

// Car and Motorcycle classes are subtypes of Vehicle
private fun MutableList<out Vehicle>.countAllCars()
: Int {

    var count: Int = 0

    for (vehicle in this) {
        if (vehicle is Car) {
            count++
        }
    }
    return count;
}


/**
 * Counts all Motorcycles in the list
 */
private fun MutableList<out Vehicle>.countAllMotorcycles(): Int {

    var count: Int = 0

    for (vehicle in this) {
        if (vehicle is Motorcycle) {
            count++
        }
    }
    return count;
}

//private fun MutableList<out Vehicle>.add(vehicle: (in Vehicle)-> Unit): Int {
//
//    var count: Int = 0
//
//    for (vehicle in this) {
//        if (vehicle is Motorcycle) {
//            count++
//        }
//    }
//    return count;
//}

/**
 *  This function generates a report of the parking lot
 *      Details such as vehicle type, hours of stay, total parking fee, and transaction id is provided
 *      as well as total number of vehicle for each type
 *
 */
fun generateReport(listOfParkedCustomers: MutableList<out Vehicle>)  {
    println("%-10s%-10s%-20s%-20s%-30s%-20s".format("","Type", "Plate Number", "Hours of Stay", "Total Parking Fee",
        "Transaction ID"))

    for (vehicle in listOfParkedCustomers) {
        var type: Char = ' '
        var tpf: Int = 0
        var plateNumber: String= ""

        // Check if the vehicle is an instance of a Car class
        if (vehicle is Car) {
            type = 'C'
            tpf = vehicle.totalParkingFee
            plateNumber = vehicle.plateNumber
        }
        // Check if the vehicle is an instance of a Motorcycle class
        if (vehicle is Motorcycle) {
            type = 'M'
            tpf = vehicle.totalParkingFee
            plateNumber = vehicle.plateNumber
        }
        println(
            "%-10s%-10s%-20s%-20d%-30d%-20s".format(
                listOfParkedCustomers.indexOf(vehicle) + 1, type, plateNumber,
                vehicle.hoursOfStay, tpf, vehicle.transactionID
            )
        )
    }

    // Count number of cars and motorcycle in a parking lot
    val countOfCars = listOfParkedCustomers.countAllCars()
    val countOfMotorcycle = listOfParkedCustomers.countAllMotorcycles()

    println("Cars: $countOfCars\nMotorcycleS: $countOfMotorcycle")
}

class ParkingReportMain {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var scanner = Scanner(System.`in`)

            println("Generate Parking Lot Report Application")

            print("Press Enter to Generate Parking Report.")
            scanner.nextLine();



            val listOfVehicle = mutableListOf(
                Car("asd198", 50, 6),
                Car("ASD098", 50, 3),
                Car("WEC499", 50, 2),
                Car("DKL523", 50, 6),


//            listOfVehicle

//        // Demo for Named arguments
//        Motorcycle(plateNumber = "SAI089", parkingFee = 25, hoursOfStay = 6),
//        Motorcycle(parkingFee = 25, plateNumber = "KLJ090", hoursOfStay = 6),
//        Motorcycle(hoursOfStay = 6, parkingFee = 25, plateNumber = "AKJ234"),
//
//                Motorcycle("OIP293", 25, 6),
//                Motorcycle("CSA235", 25, 6),
            );

//            listOfVehicle.coun






            generateReport(listOfVehicle)
        }
    }
}

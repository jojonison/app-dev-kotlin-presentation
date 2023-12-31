/*
*
*   Programmer: Maervin Villalobos
*   Date: 09 - 17 - 2023
*   Description: A sample problem about parking space
* 
*/

import kotlinx.coroutines.*
import java.util.Scanner

/* The ParkingLot class represents a parking lot with a given capacity and provides methods to park and release cars. */
class ParkingLot(capacity: Int)
{
    // Variables declarations
    private val available_slots = mutableListOf<Boolean>()
    private val random = java.util.Random()
    private var total_cars_parked = 0
    private var car_counter = 1

    // Initialize all spots as available
    init
    {
        repeat(capacity) { available_slots.add(true) }
    }

    /**
     * Simulates a car parking in a spot, staying for 2 seconds, and then departing from the spot.
     *
     */
    suspend fun park_car()
    {
        val slot_no = find_available_spot()
        if (slot_no != -1)
        {
            val car_no = car_counter++
            // Print if a car park
            println("Car $car_no parked in spot $slot_no.")

            // Simulate car parking for 2 seconds
            try
            {
                // Simulate car parking for 2 seconds
                delay(2000)
            } catch (e: Exception)
            {
                // Handle the exception (e.g., print an error message)
                println("Error while simulating car parking: ${e.message}")
            }

            // Print if a car departed from a spot
            println("Car $car_no departed from spot $slot_no.")
            // Open the parking slot
            release_spot(slot_no)
        } else
        {
            println("Car $car_counter couldn't find a parking spot and exited.")
            car_counter++
        }

        // total numbers of cars that are parked
        total_cars_parked++

        // Shows the number of available slot after 20 cars parked
        if (total_cars_parked % 20 == 0)
        {
            try
            {
                update_available_slots()
            } catch (e: Exception)
            {
                // Handle exceptions during updating available slots
                println("Error while updating available slots: ${e.message}")
            }
        }
    }

    /**
     * findAvailableSpot finds an available parking spot by randomly selecting an index from a list of
     * available spots and marking it as occupied.
     *
     * It returns an integer value representing the parking spot number. If there are
     * available spots, it returns the number of the randomly selected spot that was marked as occupied. If there are no
     * available spots, it returns -1 to indicate that there are no available spots.
     *
     */
    private fun find_available_spot(): Int
    {
        // Create a list of indices representing available spots
        val available_spots_indices = mutableListOf<Int>()
        for (index in available_slots.indices)
        {
            if (available_slots[index])
            {
                available_spots_indices.add(index)
            }
        }

        // Check if there are available spots
        return if (available_spots_indices.isNotEmpty())
        {
            // Randomly select an index from the list of available spots
            val random_index = random.nextInt(available_spots_indices.size)
            // Get the parking spot number using the randomly selected index
            val spot_no = available_spots_indices[random_index]

            // Mark the selected spot as occupied
            available_slots[spot_no] = false

            // Return the parking spot number
            spot_no
        } else
        {
            // If there are no available spots, return to indicate no available spots
            -1
        }
    }

    /**
     * Counts the number of available parking slots and prints the result.
     */
    private fun update_available_slots()
    {
        val available_slots = available_slots.count { it }
        println("Available parking slots: $available_slots")
    }

    /**
     * Updates the availability of a parking spot.
     * @param spot_no The spotNo parameter is an integer that represents the spot number of a parking spot.
     */
    private fun release_spot(spot_no: Int)
    {
        available_slots[spot_no] = true
    }
}

/**
 * Simulates cars arriving at a parking lot and parking their cars
 * randomly within a specified time range.
 */
fun main() = runBlocking {
    try
    {
        // The total capacity of the parking lot
        val parking_lot = ParkingLot(capacity = 30)
        val cars = List(100) {
            launch {
                try
                {
                    // Simulate random arrival time
                    delay((1..5).random() * 1000L)
                    parking_lot.park_car()
                } catch (e: Exception)
                {
                    // Handle exceptions during car arrival and parking
                    println("Error during car arrival and parking: ${e.message}")
                }
            }
        }
        cars.joinAll()
    } catch (e: Exception)
    {
        // Handle any unexpected exceptions in the main function
        println("Error in main function: ${e.message}")
    }
}

fun run() = runBlocking {
    try
    {
        // The total capacity of the parking lot
        val parking_lot = ParkingLot(capacity = 30)
        val cars = List(100) {
            launch {
                try
                {
                    // Simulate random arrival time
                    delay((1..5).random() * 1000L)
                    parking_lot.park_car()
                } catch (e: Exception)
                {
                    // Handle exceptions during car arrival and parking
                    println("Error during car arrival and parking: ${e.message}")
                }
            }
        }
        cars.joinAll()
    } catch (e: Exception)
    {
        // Handle any unexpected exceptions in the main function
        println("Error in main function: ${e.message}")
    }
}

class Coroutines
{
    companion object
    {
        @JvmStatic
        fun main(args: Array<String>)
        {
            var scanner = Scanner(System.`in`)

            print("Press enter to simulate example for courotine.")
            scanner.nextLine();

            run()
        }
    }
}
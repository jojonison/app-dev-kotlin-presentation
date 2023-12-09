/**
 * Description: A sample program about garbage collection that
 * allows users to se a specific date and location for their garbage collection.
 */

import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT: String = "MM/dd/yyyy"
const val NOTIFICATION: String = "Thank you! We will notify you once your waste is about to be picked up."
const val REMINDER: String = "Reminder: Please Segregate your waste before %s"

fun main () {

}

class WasteManagement {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {


            // User login
            // Variable declarations
            val username: String = "user"
            val password: String = "abcd1234"

            println("Welcome to Waste Management - Baguio City!")
            while (true) {
                print("Username: ")
                val user: String? = readlnOrNull() // Null-safety
                print("Password:")
                val pass: String? = readlnOrNull()
                if (user == username && pass == password) {
                    break
                } else {
                    println("Invalid username or password! Please try again")
                }
            }

            while (true) {
                // Variable declarations
                var pickupDate: String
                var pickupLocation: String

                // Type inference for variable and property types
                val notificationsEnabled: Boolean = false

                println("Please enter the date you want your trash to be collected [MM/dd/yyyy]: ")
                pickupDate = readln()

                println("Please enter the location of the pick-up point: ")
                pickupLocation = readln()

                try {
                    val dateFormat = SimpleDateFormat(DATE_FORMAT)
                    val parsedDate = dateFormat.parse(dateFormat.format(dateFormat.parse(pickupDate)))
                    val calendar = Calendar.getInstance()
                    calendar.time = parsedDate
                    calendar.add(Calendar.DAY_OF_YEAR, -1)
                    val reminderDate = calendar.time
                    println(String.format(REMINDER, dateFormat.format(reminderDate)))
                } catch (e: Exception) {
                    println("Invalid date format.")
                    continue
                }


                if (notificationsEnabled) {
                    println(NOTIFICATION)
                } else {
                    println("Thank you! Your waste will be picked up on $pickupDate at $pickupLocation")
                }

                // Smart Casts + typecast/converting types
                var wasteType: Any = "Plastic"
                if (wasteType is String) {
                    val wasteString: String = wasteType
                    println("Please make sure to properly segregate your $wasteString waste. ")
                }


                println("Do you want to log out? [Y/N]")
                when (readln().toUpperCase()) {
                    "Y" -> {
                        println("Thank you for using our application!")
                        return
                    }
                }
            }
        }
    }
}

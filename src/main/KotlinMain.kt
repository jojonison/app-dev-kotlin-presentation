/**
 * Main Driver Class
 */


package main

import CIDMain
import Coroutines
import ParkingReportMain
import Taxi
import java.util.Scanner
import WasteManagement


fun menu() {

    println("[1] Variables, Null Safety, Smart Casts")
    println("[2] Functions --- Extension, Use-site variance")
    println("[3] Lambda Expressions, Inline functions, Operator Overloading")
    println("[4] Classes (Data Classes, Sealed Classes, Interfaces), Destructors/ Delegations ")
    println("[5] Coroutines and Exceptions")
    println("[6] Exit")

}

fun main(arg: Array<String>) {
    var scanner = Scanner(System.`in`)
    var choice:Int = 0

    while (choice != 6) {
        println("---------KOTLIN DEMO MENU---------")
        println("By Maervin 2")
        menu()
        print("Enter choice: ")
        choice = scanner.nextInt()
        when (choice) {
            1 ->  {
                WasteManagement.main(arg)
                print("Press enter to continue.")
                scanner.nextLine()
                scanner.nextLine()

            }
            2 -> {
                ParkingReportMain.main(arg)
                print("Press enter to continue.")
                scanner.nextLine()
                scanner.nextLine()

            }
            3 -> {
                Taxi.main(arg)
                print("Press enter to continue.")
                scanner.nextLine()
                scanner.nextLine()

            }
            4 -> {
                CIDMain.main(arg)
                print("Press enter to continue.")
                scanner.nextLine()
                scanner.nextLine()

            }
            5 -> {
                Coroutines.main(arg)
                print("Press enter to continue.")
                scanner.nextLine()
                scanner.nextLine()

            }
        }
    }

    println("Thank you for using the Demo Application.")
}
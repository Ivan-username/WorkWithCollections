package TipaRabochiyCode

import java.util.*
import java.io.*

fun main(){
//    val scan = Scanner(System.`in`)
//    val list = scan.nextLine().split(",")

    val pathWays =  "D:\\user.ivan\\collections\\status_way.txt"
    val pathLegend = "D:\\user.ivan\\collections\\status_info.txt"
    val roleCount = 10
    val packet = 10816

    val option  = Option(roleCount, packet, pathWays, pathLegend)
    val diagramManager = DiagramManager(option)
    diagramManager.work()

}
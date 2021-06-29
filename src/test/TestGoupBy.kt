package test

import route.Route
import java.io.File
import java.io.File.separator


fun main() {
    val listStatusWay = File("D:\\user.ivan\\collections\\status_way.txt").readLines()
    val listStatusWayRoute = mutableListOf<Route>()
    for (i in listStatusWay.withIndex()) {
        val list = (listStatusWay[i.index].split(","))
        listStatusWayRoute.add(
                Route(
                        list[0].toInt(),
                        list[1].toInt(),
                        list[2].toInt(),
                        list[3]
                )
        )
    }


    val roles = listOf("DU_ROOT", "DU_ALFABANK_USERS", "DU_BACKOFFICE_ADMIN")

    println(roles)
    println(roles.joinToString ())

    val filtered = listStatusWayRoute
            .filter { it.packet == 10816 }
            .filter { roles.contains(it.person) }
            .toList();


//    val groupByPerson = filtered.groupBy { it.person }
//    val roleSizeMap = filtered
//            .groupBy { it.person }
//            .map { entry -> entry.key to entry.value.size }
//            .toMap()
//    println(roleSizeMap.filter { entry -> entry.value < 10 })
//

    val toMap = filtered
            .groupBy { it.source.toString() + " --> " + it.target.toString() }
            .map { entry -> entry.key to entry.value.map { route -> route.person }.toList() }
            .toMap()
    println(toMap)



}




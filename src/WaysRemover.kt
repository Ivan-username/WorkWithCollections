package remover

import legend.Legend
import route.Route

class WaysRemover (val listStatusWayRoute: MutableList<Route>, val pakets: Int, val admins: List<String>, var listStatusInfoLegend: List<Legend>){

    var waysToPrinter = mutableListOf<Route>()
    var infoToPrinter = mutableListOf<String>()

    fun remover(){
        val listFilteredByPackets = listStatusWayRoute
                .filter { i -> i.packet == pakets }
                .toMutableList()
        waysToPrinter = mutableListOf<Route>()
        if (admins.size == 1){
            waysToPrinter = listFilteredByPackets
                    .filter { i -> i.person == admins[0] }
                    .toMutableList()
        }

//        todo----------------------------------------------------------------todo

        val infoSet = mutableSetOf<Int>()
        for (i in waysToPrinter.withIndex()){
            infoSet.add(waysToPrinter[i.index].source)
            infoSet.add(waysToPrinter[i.index].target)
        }
        println(infoSet)
    }
}
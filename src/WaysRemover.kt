package remover

import legend.Legend
import route.Route

class WaysRemover (val listStatusWayRoute: MutableList<Route>,
                   val pakets: Int,
                   val admins: List<String>,
                   var listStatusInfoLegend: Map<Int, Legend>) {

    var waysToPrinter = mutableListOf<Route>()
    var infoToPrinter = mutableListOf<String>()

    fun remover(){
        val listFilteredByPackets = listStatusWayRoute
                .filter { i -> i.packet == pakets }
                .toMutableList()
        if (admins.size == 1){
            waysToPrinter = listFilteredByPackets
                    .filter { i -> i.person == admins[0] }
                    .toMutableList()

            for (i in waysToPrinter.withIndex()){
                val item = waysToPrinter[i.index]
                println("${item.source} --> ${item.target}")
            }
        }


//        todo----------------------------------------------------------------todo

//        val infoSet = mutableSetOf<Int>()
//        for (i in waysToPrinter.withIndex()){
//            infoSet.add(waysToPrinter[i.index].source)
//            infoSet.add(waysToPrinter[i.index].target)
//        }
//        //println(infoSet)
//
//
//        for (nodeName in infoSet) {
//            //1013
//            println("$nodeName: ${listStatusInfoLegend[nodeName]?.legend}")
//        }
    }
}
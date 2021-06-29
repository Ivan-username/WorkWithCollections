package TipaRabochiyCode



/*
listWays
[du_admin]
[ALFA_PIF_ROOT, EDF-BACKOFFICE]
...
[DU_OPP_ADMIN]
 */

data class DataForPrinter(val waysToPrinter: List<Ways>, val legendsToPrinter: MutableList<MutableList<Legend>>, val boolean: Boolean)

class Preparer (var rawData: RawData, var listWays: List<List<String>>, val option: Option){

    fun preparation(){
        var filteredListOfWays = listOf<Ways>()
        var flag = true


        for (i in listWays.withIndex()){
            flag = listWays[i.index].size == 1

//            todo     --- Ways ---

            filteredListOfWays = rawData.listStatusWays
                    .asSequence()
                    .filter { listWays[i.index].contains(it.role) }
                    .filter { it.paket == option.packet }
                    .toList()
//            println(filteredListOfWays)

//            todo     --- Legends ---

            val setOfLegend = mutableSetOf<Int>()
            for (entry in filteredListOfWays.withIndex()){
                setOfLegend.add(filteredListOfWays[entry.index].source)
                setOfLegend.add(filteredListOfWays[entry.index].target)
            }

            val listOfLegend = mutableListOf<MutableList<Legend>>()
            for (i in setOfLegend) {
                listOfLegend.add(  rawData.listStatusInfoLegend
                        .filter { it.target == i }
                        .toMutableList()
                )
            }

            Printer(DataForPrinter(filteredListOfWays, listOfLegend, flag)).printing()
        }
    }
}
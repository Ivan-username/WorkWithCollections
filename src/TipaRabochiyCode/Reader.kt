package TipaRabochiyCode

import java.io.File

data class Ways(var paket: Int, var source: Int, var target: Int, var role: String)

data class Legend(var target: Int, var legend: String)

data class RawData(val listStatusWays: List<Ways>, val listStatusInfoLegend: List<Legend>)

//todo-------------------------------------------------------------------------------------

class Reader(val waysPath: String, val legendPath: String) {

    fun read(): RawData {
        val listStatusWay = File(waysPath).readLines() //todo  "D:\\user.ivan\\collections\\status_way.txt"

        val listStatusWays = mutableListOf<Ways>()
        for (i in listStatusWay.withIndex()) {
            val list = (listStatusWay[i.index].split(","))
            listStatusWays.add(
                    Ways(
                            list[0].toInt(),
                            list[1].toInt(),
                            list[2].toInt(),
                            list[3]
                    )
            )
        }

        val listStatusInfo = File(legendPath).readLines() //todo  "D:\\user.ivan\\collections\\status_info.txt"

        val listStatusInfoLegend = mutableListOf<Legend>()
        for (i in listStatusInfo.withIndex()) {
            val list = (listStatusInfo[i.index].split(","))
            listStatusInfoLegend.add(
                    Legend(
                            list[0].toInt(),
                            list[1]
                    )
            )
        }
        return RawData(listStatusWays, listStatusInfoLegend);
    }
}


package TipaRabochiyCode

class Printer(var dataForPrinter: DataForPrinter) {


    fun printing() {
        if (dataForPrinter.boolean) {
            println("[plantuml,${dataForPrinter.waysToPrinter[0].role},svg,opts=\"inline\",svg-type=\"inline\"]")
        } else {
            println("[plantuml,other,svg,opts=\"inline\",svg-type=\"inline\"]")
        }
        println("----")
        val outputLegend = dataForPrinter.legendsToPrinter.flatten()
        for (i in outputLegend.withIndex()) {
            println(
                    outputLegend[i.index].target.toString()
                            + ":" +
                            outputLegend[i.index].legend
            )
        }

        println()

        if (dataForPrinter.boolean) {
            val filteredList = dataForPrinter.waysToPrinter
                    .groupBy { it.source.toString() + " --> " + it.target.toString() }
                    .map { entry -> entry.key to entry.value.map { route -> route.role } }
                    .toList()
                    .toMap()

            val toPrinterListOfLoners = mutableListOf<String>()

            for (entry in filteredList) {
                toPrinterListOfLoners.add(entry.key + ": ")
            }

            toPrinterListOfLoners.forEach { entry -> println(entry) }

        } else {
            val filteredList = dataForPrinter.waysToPrinter
                    .groupBy { it.source.toString() + " --> " + it.target.toString() }
                    .map { entry -> entry.key to entry.value.map { route -> route.role } }
                    .toList()
                    .toMap()

            val toPrinterListOfLoners = mutableListOf<String>()

            for (entry in filteredList) {
                toPrinterListOfLoners.add(entry.key + ": " + entry.value.joinToString())
            }

            toPrinterListOfLoners.forEach { entry -> println(entry) }

        }

        println("----")
        for (i in 0..3) println()

    }
}
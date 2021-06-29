package TipaRabochiyCode

class DiagramManager (var option: Option){

    fun work(){

        val rawData = Reader(option.pathWays, option.pathLegend).read()

        val analyzedWays= Analyzer(rawData.listStatusWays, option).analysis()

        Preparer(rawData, analyzedWays, option).preparation()


        /*
        [
        [DU_OPP_ADMIN],
        [DU_ADMIN],
        [DU_DVK_ADMIN,EDF-CALLCENTRE,DU_AUTH],
        ]
         */

//
//        Preparator.prepare(rawData, List<String>)
//        Pringer.print(Collection, )

    }
}
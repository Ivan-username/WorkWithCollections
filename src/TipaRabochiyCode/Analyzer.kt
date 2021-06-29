package TipaRabochiyCode



class Analyzer (val listStatusWays: List<Ways>, var  option:Option){

    fun analysis(): List<List<String>>{

        val output = mutableListOf<MutableList<String>>()

        val filteredWays = listStatusWays
                .filter { it.paket == option.packet }
                .groupBy { it.role }
                .map { entry -> entry.key to entry.value.size }
                .toMap()

//        output = listOf(
//                filteredWays.filter { entry -> entry.value < option.roleCount }.keys.toList(),
//                filteredWays.filter { entry -> entry.value > option.roleCount }.keys.toList()
//        )
//        for (i in output[0].withIndex()){
//            println(output[0][i.index])
//        }

        val tmp = mutableListOf<String>()
        for (entry in filteredWays) {
            val role = entry.key
            if (entry.value > option.roleCount){
                output.add(mutableListOf(role))
            } else {
                tmp.add(role)
            }
        }
        output.add(tmp)
//        println(output)
        return output
    }
}
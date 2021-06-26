package statusInfo

import main.*
import statusWay.StatusWay

class StatusInfo (val listStatusInfo: List<String>){

    fun statusInfoChanger(){
        for (i in listStatusInfo.withIndex()){
            val list = (listStatusInfo[i.index].split(","))
            println("${list[0]}: ${list[1]}")
        }
        for (i in 1..3){
            println()
        }
    }
}
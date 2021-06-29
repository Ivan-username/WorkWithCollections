package test

import java.io.File


fun main (){

    val listStatusWay  = File("D:\\user.ivan\\collections\\status_way.txt").readLines()
    var lister = mutableListOf<String>()
    lister = listStatusWay as MutableList<String>
    val answerList = mutableListOf<String>()
    for (i in lister.withIndex()) {
        val firstCheckList = (lister[i.index].split(","))
        for (j in lister.withIndex()){
            val secondCheckList = (lister[i.index].split(","))
            if (firstCheckList[1] == secondCheckList[1] && firstCheckList[2] == secondCheckList[2]){
                answerList.add(secondCheckList[3])
//                lister.removeAt(j.index)
            }
        }
        print("${firstCheckList[1]} --> ${firstCheckList[2]}: ")
        for (k in answerList.withIndex()){
            print("${answerList[k.index]}, ")
        }
    }
}
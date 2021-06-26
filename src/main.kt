package main

import legend.*
import java.io.File
import java.util.*
import route.*
import remover.*

internal fun main(){

//    todo ------------------------ ВВОД ДАННЫХ ДЛЯ ФИЛЬТРАЦИИ---------------------
    val scan = Scanner(System.`in`)
    println("Enter the package, please")
    val paket = 10817
    println("Enter the admins, please")
//    val admins = scan.nextLine().split(",")
    println("a;fjdnv;cvjn")
    val admins = listOf("DU_ROOT")
//    todo --------------------------------ПОИСК ДАННЫХ----------------------------
    val listStatusWay = File("D:\\user.ivan\\collections\\status_way.txt").readLines()
    val listStatusInfo = File("D:\\user.ivan\\collections\\status_info.txt").readLines()
//    val listStatusWay = File("D:\\user.ivan\\collections\\status_way_test.txt").readLines()
//    val listStatusInfo = File("D:\\user.ivan\\collections\\status_info_test.txt").readLines()

//    val statusInfoClass = StatusInfo(listStatusInfo)
//    statusInfoClass.statusInfoChanger()
//
//    val statusWayClass = StatusWay(listStatusWay)
//    statusWayClass.statusWayChanger() )
    convertingWaysAndInfo(listStatusWay, paket, admins, listStatusInfo)
}

fun convertingWaysAndInfo(listStatusWay: List<String>, paket: Int, admins: List<String>, listStatusInfo: List<String>){
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
    WaysRemover(listStatusWayRoute, paket, admins, listStatusInfoLegend).remover()
}
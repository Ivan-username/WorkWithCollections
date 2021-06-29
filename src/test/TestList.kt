package test

import route.Route
import java.io.File
import java.io.File.separator
import javax.swing.text.MutableAttributeSet


fun main() {
//    val list = mutableListOf<MutableList<String>>();
//    list.add(mutableListOf("1", "2"))
//    list.add(mutableListOf("11", "22"))
//    list.add(mutableListOf("111", "222"))



    var list : MutableList<MutableList<String>>  = mutableListOf(
            mutableListOf("1"),
            mutableListOf("2"),
            mutableListOf("3", "4", "5")
    )

    var raw : MutableList<String>  = mutableListOf("1", "2", "3", "4", "5" )


    for (item in list) {

        if (item.size  == 1) {

        } else {

        }

        val string = raw
                .filter { it -> item.contains(it) }
                .joinToString()
        println(string)
    }


    //println(list)



}




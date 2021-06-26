package statusWay

import main.*

class StatusWay(val listStatusWay: List<String>){
    var packages = 0
    var source = 0
    var target = 0
    var persons = mutableListOf<String>()

    fun statusWayChanger() {
        var flag = true
        for (i in listStatusWay.withIndex()){
            val list = (listStatusWay[i.index].split(","))
            if (flag){
                source = list[1].toInt()
                target = list[2].toInt()
                flag = false
            }
            if (source == list[1].toInt() && target == list[2].toInt()){
                persons.add(list[3])
            } else {
//                flag = true
                print("$source --> $target: ")
                for (k in persons.withIndex()){
                    print("${persons[k.index]},")
                }
                println()
                source = list[1].toInt()
                target = list[2].toInt()
                persons.clear()
                persons.add(list[3])
            }
        }
    }
}
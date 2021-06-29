package legend

data class Legend (var target: Int, var legend: String) {
    override fun toString(): String {
        return "($target='$legend')"
    }
}
package hu.ujszaszik.moviemaniac.util

fun Long.toMillionsText(): String {
    val millions = this / 1_000_000.0
    return "%.2f M".format(millions)
}

fun Double.roundToOneDecimal(): String {
    return "%,.1f".format(this)
}
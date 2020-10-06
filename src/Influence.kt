import java.awt.Point
import java.time.LocalTime

abstract class Influence {
    var force = 0
    abstract fun get(p : Point) : Int
}

class Humidity : Influence(){
    override fun get(p: Point): Int = p.x * p.y *force
}

class Mineral : Influence(){
    override fun get(p: Point): Int = when (p.x){
        in 0..300 -> 50
        in 300..600 -> 100
        in 600..900 -> 150
        else -> 0
    }
}

open class SunLight : Influence(){
    val DAY_CIRCLE = 10

    final override fun get(p: Point): Int {
        return when (minutes()){
            in 0..3 -> force
            in 4..7 -> force * force
            in 8..10 -> force
            else -> 0
        }
    }

    open fun minutes(): Int = LocalTime.now().minute % DAY_CIRCLE

}
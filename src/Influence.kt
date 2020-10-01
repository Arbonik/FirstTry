import java.awt.Point
import java.time.LocalDateTime

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

class SunLight : Influence(){
    val DAY_CIRCLE = 10
    override fun get(p: Point): Int {
        var time = LocalDateTime.now()
        var moment = time.minute % DAY_CIRCLE
        return when (moment){
            in 0..3 -> force
            in 4..6 -> force * force
            in 7..10 -> force
            else -> 0
        }
    }
}
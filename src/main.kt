import java.awt.Point

fun main() { // 11 задача
    var area = Area().apply {
        influences[1].force = 4
    }
    var plant = Plant().apply {
        location = Point(20, 10)
    }

    area.plants.add(plant)
    println(area.plants[0].height)

    area.countInfluens()

    println(area.plants[0].height)
}
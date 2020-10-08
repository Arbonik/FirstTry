package view

import Area
import Plant
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Point
import javax.swing.JFrame

class AreaView : JFrame(){
    var area = Area().apply {
        plants = mutableListOf(
            Plant().apply {
            r = 100
            location = Point(400, 300)
        },
            Plant().apply {
                r =200
                location = Point(200, 100)
            })

    }
    override fun paint(g: Graphics?) {
        var graphic = g as Graphics2D
        graphic.color = Color.GREEN
        for (plant in area.plants){
            graphic.fillOval(plant.location.x,
            plant.location.y,
            plant.r,
            plant.r)

        }
    }
}
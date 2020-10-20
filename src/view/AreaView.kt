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
        plants = MutableList(30) {
            Plant().apply {
                r = (30..130).random()
                location = Point((0..900).random(), (0..900).random())
            }
        }
    }

    override fun paint(g: Graphics?) {
        var graphic = g as Graphics2D
//        Сортировка по высоте
        var xc = Array(1000 * 1000){
            area.influences[0].get(Point(it % 1000, it / 1000)) / 1000000f
        }
        for (y in 0..999){
            for (x in 0..999){
                graphic.color = Color.getHSBColor(1f, xc[ y*1000 + x ],1f)
                graphic.drawRect(x,y,1,1)
            }
        }

        area.plants.sortBy { it.height }
        for (plant in area.plants){
//            изменение цвета по индивиуальному цветку
            graphic.color = plant.color

            graphic.fillOval(plant.location.x,
            plant.location.y,
            plant.r,
            plant.r)
        }
//        перерасчет роста
     //   area.countInfluens()
        //repaint()
    }

}
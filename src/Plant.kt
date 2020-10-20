import java.awt.Color
import java.awt.Point

class Plant {
    var height : Int = 0
    var r : Int = 0
    var location : Point = Point()
//    случайная генерация цвета
    var color = Color.getHSBColor((0..255).random()/255f,(0..255).random()/255f,(0..255).random()/255f)
}
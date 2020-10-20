import view.AreaView
import java.awt.Point

fun main() { // 11 задача
    var view = AreaView()
    view.setSize(1000,1000)
    view.show()
    while (true){
        readLine()
        view.area.countInfluens()
        view.repaint()
    }
}
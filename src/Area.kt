class Area{
    var plants = mutableListOf<Plant>()
    var influences = arrayOf<Influence>(
        Humidity(), SunLight(), Mineral()
    )

    fun countInfluens(){
        for (i in 0 until plants.size){
            var sumInfluence = 0
            for (m in influences)
                sumInfluence += m.get(plants[i].location)
            plants[i].height += sumInfluence
        }
    }

}
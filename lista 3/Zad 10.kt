data class Point(val x: Int, val y: Int){
    operator fun plus(p: Point): Point {
        return Point(x + p.x, y + p.y)
    }

    operator fun plus(p: Int) = Point(this.x + p, this.y + p)

    operator fun minus(p: Point): Point {
        return Point(this.x - p.x, this.y - p.y)
    }

    operator fun times(p: Point): Point {
        return Point(x * p.x, y * p.y)
    }

    operator fun inc() = Point(x +1, y + 1)

    operator fun dec() = Point(x -1, y - 1)

    operator fun not(): Point {
        return Point(this.x * -1, this.y * - 1)
    }
}


//-------------------------------------------------
fun main(){
    var p1 = Point(1, 1)
    val p2 = Point(2, 2)




    println(p1 + p2)
    p1=Point(1,1)

    p1 += 1
    println(p1)
    p1 = Point(1,1)


    println(p1 - p2)
    p1=Point(1,1)

    println(p1 * p2)
    p1=Point(1,1)


    p1++
    println(p1)

    p1 = Point(1,1)
    p1--
    println(p1)

    p1=Point(1,1)
    println(!p1)



}
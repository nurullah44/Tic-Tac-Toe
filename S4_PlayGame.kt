fun main() {
    val x = readln() // get game position from the user
    val Board = MutableList(3) {MutableList(3){'0'} }
    var counter = 0
    for (i in 0..2) for ( j in 0..2){
        Board[i][j] = x[counter]
        counter++
    }
    fun PrintBoard( Board: MutableList<MutableList<Char>>) {

        println("---------")
        println("| ${Board[0][0]} ${Board[0][1]} ${Board[0][2]} |\n| " +
                "${Board[1][0]} ${Board[1][1]} ${Board[1][2]} |\n|" +
                " ${Board[2][0]} ${Board[2][1]} ${Board[2][2]} |")
        println("---------")
    }
    PrintBoard(Board)
    while (true) {
        try {
            val (x1,y1) = readln().split(" ").map { it.toInt() }
            if (x1 > 3 || y1 > 3){
                println("Coordinates should be from 1 to 3!")
                continue
            }
            if (Board[x1-1][y1-1] == 'X' || Board[x1-1][y1-1] == 'O') {
                println("This cell is occupied! Choose another one!")
                continue
            }
            Board[x1-1][y1-1] = 'X'
            PrintBoard(Board)
            break
        } catch (e: Exception) {
            println("You should enter numbers!")
        }
    }
}
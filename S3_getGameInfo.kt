fun main() {
    val x = readln() // get game position from the user
    val X_Count = x.count {it == 'X'}
    val O_Count = x.count {it == 'O'}
    val UnderscoreCount = x.count {it == '_'}
    val Board = MutableList(3) {MutableList(3){'0'} }
    var counter = 0
    var winCount = 0
    var winner = '-'
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
    if (Board[0][0] == Board[0][1] && Board[0][0] == Board[0][2] )
        winCount ++
        winner = Board[0][0]
    if (Board[1][0] == Board[1][1] && Board[1][0] == Board[1][2] ) {
        winCount++
        winner = Board[1][0]
    }
    if (Board[2][0] == Board[2][1] && Board[2][0] == Board[2][2] ) {
        winCount++
        winner = Board[2][0]
    }
    if (Board[0][0] == Board[1][0] && Board[0][0] == Board[2][0] ) {
        winCount++
        winner = Board[0][0]
    }
    if (Board[0][1] == Board[1][1] && Board[0][1] == Board[2][1] ) {
        winCount++
        winner = Board[1][1]
    }
    if (Board[0][2] == Board[1][2] && Board[0][2] == Board[2][2] ) {
        winCount++
        winner = Board[1][2]
    }
    if (Board[0][0] == Board[1][1] && Board[0][0] == Board[2][2] ) {
        winCount++
        winner = Board[0][0]
    }
    if (Board[2][0] == Board[1][1] && Board[2][0] == Board[0][2] ) {
        winCount++
        winner = Board[2][0]
    }
    when {
        kotlin.math.abs( X_Count - O_Count ) >= 2  -> print( "Impossible")
        winCount > 1 -> print( "Impossible")
        winCount == 0 && UnderscoreCount != 0 || (winCount == 1 && winner =='_')-> print("Game not finished")
        winCount == 1 -> print("$winner wins")
        winCount == 0 && UnderscoreCount == 0 -> print("Draw")
    }
}
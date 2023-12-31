fun main() {
    val Board = MutableList(3) {MutableList(3){' '} }
    var counter = 0
    var start = 'X'
    val UnderscoreCount = Board.joinToString(",").count {it == ' '}
    var winCount = 0
    var winner = '-'
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
            Board[x1-1][y1-1] = start
            if ( start == 'X' ) start = 'O' else start = 'X'
            PrintBoard(Board)
            if (Board[0][0] == Board[0][1] && Board[0][0] == Board[0][2] )
                if (Board[0][0] != ' ') {
                    winCount++
                    winner = Board[0][0]
                }
            if (Board[1][0] == Board[1][1] && Board[1][0] == Board[1][2] ) {
                if (Board[1][0] != ' ') {
                    winCount++
                    winner = Board[1][0]
                }
            }
            if (Board[2][0] == Board[2][1] && Board[2][0] == Board[2][2] ) {
                if (Board[2][0] != ' ') {
                    winCount++
                    winner = Board[2][0]
                }
            }
            if (Board[0][0] == Board[1][0] && Board[0][0] == Board[2][0] ) {
                if (Board[0][0] != ' ') {
                    winCount++
                    winner = Board[0][0]
                }
            }
            if (Board[0][1] == Board[1][1] && Board[0][1] == Board[2][1] ) {
                if (Board[0][1] != ' ') {
                    winCount++
                    winner = Board[1][1]
                }
            }
            if (Board[0][2] == Board[1][2] && Board[0][2] == Board[2][2] ) {
                if (Board[1][2] != ' ') {
                    winCount++
                    winner = Board[1][2]
                }
            }
            if (Board[0][0] == Board[1][1] && Board[0][0] == Board[2][2] ) {
                if (Board[0][0] != ' ') {
                    winCount++
                    winner = Board[0][0]
                }
            }
            if (Board[2][0] == Board[1][1] && Board[2][0] == Board[0][2] ) {
                if (Board[2][0] != ' ') {
                    winCount++
                    winner = Board[2][0]
                }
            }
            when {
                winCount == 0 && UnderscoreCount != 0 || (winCount == 1 && winner =='_')-> continue
                winCount == 1 -> {
                    print("$winner wins")
                    break
                }
                winCount == 0 && UnderscoreCount == 0 -> {
                    print("Draw")
                    break
                }
            }
        } catch (e: Exception) {
            println("You should enter numbers!")
        }
    }
}
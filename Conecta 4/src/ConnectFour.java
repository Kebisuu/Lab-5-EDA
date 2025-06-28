public class ConnectFour {
    private char[][] Tablero;
    private char Simbolo;
    public ConnectFour() {
        Tablero = new char[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                Tablero[i][j] = ' ';
            }
        }
        Simbolo = 'X';
    }
    public boolean makeMove(int z) {
        if (z < 0 || z >= 6) return false;
        for (int fila = 6; fila >= 0; fila--) {
            if (Tablero[fila][z] == ' ') {
                Tablero[fila][z] = Simbolo;
                Simbolo = (Simbolo == 'X') ? 'O' : 'X';
                return true;
            }
        }
        return false;
    }
    public char isGameOver() {
        for (int fila = 0; fila < 7; fila++) {
            for (int columna = 0; fila < 3; fila++) {
                char c = Tablero[fila][columna];
                if (c != ' ' &&
                        c == Tablero[fila][columna+1] &&
                        c == Tablero[fila][columna+2] &&
                        c == Tablero[fila][columna+3])
                    return c;
            }
        }
        for (int columna = 0; columna < 6; columna++) {
            for (int fila = 0; fila < 4; fila++) {
                char c = Tablero[fila][columna];
                if (c != ' ' &&
                        c == Tablero[fila+1][columna] &&
                        c == Tablero[fila+2][columna] &&
                        c == Tablero[fila+3][columna])
                    return c;
            }
        }
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                char c = Tablero[fila][columna];
                if (c != ' ' &&
                        c == Tablero[fila+1][columna+1] &&
                        c == Tablero[fila+2][columna+2] &&
                        c == Tablero[fila+3][columna+3])
                    return c;
            }
        }
        for (int fila = 3; fila< 7; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                char c = Tablero[fila][columna];
                if (c != ' ' &&
                        c == Tablero[fila-1][columna+1] &&
                        c == Tablero[fila-2][columna+2] &&
                        c == Tablero[fila-3][columna+3])
                    return c;
            }
        }
        boolean lleno = true;
        for (int fila = 0; fila < 7; fila++)
            for (int columna = 0; columna < 6; columna++)
                if (Tablero[fila][columna] == ' ') lleno = false;
        if (lleno) return 'E';
        return ' ';
    }
    public char[][] getTablero() {return Tablero;}
    public char getSimbolo() {return Simbolo;}
}
package game;

import board.ChessGraph;
import chesspiece.*;

public class Game {
    public static void main(String[] args) {
        // Inicializa o tabuleiro
        ChessGraph chessBoard = ChessGraph.getGraphInstance();
        chessBoard.initializeNodes();
        chessBoard.fillNodes();

        // Exibe o tabuleiro inicial
        System.out.println("Tabuleiro inicial:");
        chessBoard.display();

        // Testa alguns movimentos possíveis para uma peça (por exemplo, um cavalo)
        ChessPiece knight = new Knight(Color.WHITE, chessBoard.getNode(0, 1));

        System.out.println("Movimentos possíveis para o cavalo na posição (0, 1):");
        knight.getPossibleMoves().forEach(System.out::println);

        // Testa alguns movimentos possíveis para outra peça (por exemplo, uma torre)
        ChessPiece rook = new Rook(Color.BLACK, chessBoard.getNode(7, 7));
        System.out.println("Movimentos possíveis para a torre na posição (7, 7):");
        rook.getPossibleMoves().forEach(System.out::println);

        // Implemente mais testes conforme necessário
    }
}

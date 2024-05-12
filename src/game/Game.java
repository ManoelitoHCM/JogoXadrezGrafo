package game;

import board.ChessGraph;
import board.ChessNode;
import chesspiece.*;

public class Game {
    public static void main(String[] args) {
        // Inicializa o tabuleiro
        ChessGraph chessBoard = ChessGraph.getGraphInstance();

        // Exibe o tabuleiro inicial
        System.out.println("Tabuleiro inicial:");
        chessBoard.display();

        // Testa alguns movimentos possíveis para uma peça (por exemplo, um cavalo)
        ChessPiece knight = chessBoard.getNode(0, 1).getPiece();
        System.out.println("Movimentos possíveis para o cavalo na posição (0, 1):");
        knight.filterValidMoves(chessBoard.getNode(0, 1)).forEach(System.out::println);
        knight.move(chessBoard.getNode(2, 2));
        chessBoard.display();
        knight.filterValidMoves(chessBoard.getNode(2, 2)).forEach(System.out::println);

        // Testa alguns movimentos possíveis para outra peça (por exemplo, uma torre)
        //ChessPiece rook = chessBoard.getNode(7, 7).getPiece();
        //System.out.println("Movimentos possíveis para a torre na posição (7, 7):");
        //rook.filterValidMoves(chessBoard.getNode(7, 7)).forEach(System.out::println);

        // Implemente mais testes conforme necessário
    }}

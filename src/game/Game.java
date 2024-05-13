package game;

import board.ChessGraph;
import board.ChessNode;
import chesspiece.*;

import java.util.Scanner;

public class Game {

    private static ChessGraph chessBoard;
    private static Color currentPlayer;

    public static void main(String[] args) {
        chessBoard = ChessGraph.getGraphInstance();
        currentPlayer = Color.WHITE;

        System.out.println("Tabuleiro inicial:");
        chessBoard.display();

        startGame();
    }

    private static void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("É a vez do jogador " + currentPlayer);
            System.out.println("Digite a posição da peça que você deseja mover.");
            System.out.print("Linha: ");
            int rowFrom = scanner.nextInt() - 1;
            System.out.print("Coluna: ");
            int colFrom = scanner.nextInt() - 1;

            ChessNode fromNode = chessBoard.getNode(rowFrom, colFrom);
            ChessPiece piece = fromNode.getPiece();
            System.out.println(piece.getColor());

            System.out.println("A peça selecionada foi: " + piece.getClass().getSimpleName());
            System.out.println("Jogadas possíveis para a peça selecionada:");
            piece.filterValidMoves(fromNode).forEach(System.out::println);

            System.out.println("Digite a posição para onde você deseja mover a peça.");
            System.out.print("Linha: ");
            int rowTo = scanner.nextInt() - 1;
            System.out.print("Coluna: ");
            int colTo = scanner.nextInt() - 1;

            ChessNode toNode = chessBoard.getNode(rowTo, colTo);

            if (fromNode == null || toNode == null) {
                System.out.println("Posição inválida, tente novamente.");
                continue;
            }

            if (!fromNode.hasPiece()) {
                continue;
            }

            if (!piece.filterValidMoves(fromNode).contains(toNode)) {
                System.out.println("Movimento inválido, tente novamente.");
                continue;
            }

            piece.move(toNode);
            chessBoard.display();

            if (isWinner()) {
                System.out.println("Jogador " + currentPlayer + " venceu!");
                break;
            }

            currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
    }

    private static boolean isWinner() {
        // todo
        return false;
    }
}

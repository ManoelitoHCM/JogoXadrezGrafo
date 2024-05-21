package game;

import board.ChessGraph;
import board.ChessNode;
import chesspiece.*;
import exceptions.*;
import search.BreadthFirstSearch;

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
            int rowFrom = scanner.nextInt();
            System.out.print("Coluna: ");
            int colFrom = scanner.nextInt();

            ChessNode fromNode = chessBoard.getNode(rowFrom, colFrom);
            if (fromNode == null || !fromNode.hasPiece()) {
                System.out.println("Posição inválida ou não há peça na posição selecionada, tente novamente.");
                continue;
            }

            ChessPiece piece = fromNode.getPiece();
            if (piece.getColor() != currentPlayer) {
                System.out.println("Não é sua vez de jogar essa peça. Tente novamente.");
                continue;
            }

            System.out.println("A peça selecionada foi: " + piece.getClass().getSimpleName());
            System.out.println("Jogadas possíveis para a peça selecionada:");
            piece.filterValidMoves(fromNode).forEach(System.out::println);

            System.out.println("Digite a posição para onde você deseja mover a peça.");
            System.out.print("Linha: ");
            int rowTo = scanner.nextInt();
            System.out.print("Coluna: ");
            int colTo = scanner.nextInt();

            ChessNode toNode = chessBoard.getNode(rowTo, colTo);

            Move move = new Move(fromNode, toNode);

            try {
                move.execute();
            } catch (NoPieceOnNodeException | NotPlayersTurnException | InvalidMoveException e) {
                System.out.println(e.getMessage());
                continue;
            }

            chessBoard.display();

            if (isWinner(toNode)) {
                System.out.println("Jogador " + currentPlayer + " venceu!");
                break;
            }

            currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
    }

    private static boolean isWinner(ChessNode node) {
        return BreadthFirstSearch.findOppositeKing(node) == null;
    }
}

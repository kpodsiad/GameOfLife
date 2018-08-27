package pl.kamil;

import java.io.PrintStream;

public class Console
{
    private Board board;
    private PrintStream stream;

    public Console(Board board)
    {
        this.board = board;
        stream = System.out;
    }

    public Console(Board board, PrintStream stream)
    {
        this.board = board;
        this.stream = stream;
    }

    public void printBoard()
    {
        stream.print(board);
    }

    public void printNextBoard()
    {
        board = board.nextGeneration();
        stream.println(board);
    }

    public static void main(String[] args)
    {
        Board board = new Board(5);
        board.setAlive(1, 1);
        board.setAlive(1, 2);
        board.setAlive(1, 3);
        board.setAlive(1, 4);
        board.setAlive(2, 4);

        Console console = new Console(board);
        console.printBoard();
        console.printNextBoard();
        console.printNextBoard();


    }

}

package pl.kamil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest2
{
    private Board board;

    @BeforeEach
    void setUp()
    {
        board = new Board(4);
    }

    @Test
    void shouldReturnNeighbours()
    {

        List<Cell> neighbours = board.getCell(0, 0).getNeighours(board);
        List<Cell> expected = new LinkedList<>();

        expected.add(board.getCell(3, 3));
        expected.add(board.getCell(3, 0));
        expected.add(board.getCell(3, 1));
        expected.add(board.getCell(0, 3));
        expected.add(board.getCell(0, 1));
        expected.add(board.getCell(1, 3));
        expected.add(board.getCell(1, 0));
        expected.add(board.getCell(1, 1));

        assertEquals(expected, neighbours);
    }

    @Test
    void shouldBeChildAlive()
    {
        board.getCell(1, 0).setAlive(true);
        board.getCell(1, 1).setAlive(true);
        board.getCell(1, 2).setAlive(true);

        assertAll(
                () -> assertEquals(true, board.getCell(0, 1).isChildAlive(board)),
                () -> assertEquals(true, board.getCell(1, 1).isChildAlive(board)),
                () -> assertEquals(true, board.getCell(2, 1).isChildAlive(board))
        );
    }
}
package pl.kamil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest
{
    private Cell cell;

    @BeforeEach
    void setUp()
    {
        cell = new Cell(1, 1);
    }

    @Test
    void shouldCreateCell()
    {
        //Cell cell = new Cell(1, 1);
        assertAll(
                () -> assertEquals(1, cell.getRowIndex()),
                () -> assertEquals(1, cell.getColumnIndex()),
                () -> assertEquals(false, cell.isAlive())
        );
    }

    @Test
    void shouldMakeCellAlive()
    {
        //Cell cell = new Cell(1, 1);
        cell.setAlive(true);
        assertEquals(true, cell.isAlive());
    }

    @Test
    void toStringDeadTest()
    {
        assertEquals(cell.getDEAD(), cell.toString());
    }

    @Test
    void toStringAliveTest()
    {
        assertEquals(cell.getALIVE(), cell.toString());
    }


}
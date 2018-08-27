package pl.kamil;

import java.util.LinkedList;
import java.util.List;

public class Cell
{
    private final String ALIVE = "O";
    private final String DEAD = " ";
    private final int rowIndex;
    private final int columnIndex;
    private boolean alive;

    public Cell(int rowIndex, int columnIndex)
    {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        alive = false;
    }

    public String getALIVE()
    {
        return ALIVE;
    }

    public String getDEAD()
    {
        return DEAD;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    public int getRowIndex()
    {
        return rowIndex;
    }

    public int getColumnIndex()
    {
        return columnIndex;
    }


    public boolean isChildAlive(Board board)
    {
        int neighboursAlive = 0;
        for (var neighbour : getNeighours(board))
        {
            if(neighbour.alive)
            {
                neighboursAlive++;
            }
        }
        if(alive)
        {
            if(neighboursAlive == 2 || neighboursAlive == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        if(neighboursAlive == 3)
        {
            return true;
        }
        return false;
    }

    public List<Cell> getNeighours(Board board)
    {
        List<Cell> returnList = new LinkedList<>();

        for (int rowDelta = -1; rowDelta <= 1; rowDelta++)
        {
            for (int columnDelta = -1; columnDelta <= 1; columnDelta++)
            {
                if (rowDelta == 0 && columnDelta == 0)
                {
                    continue;
                }
                returnList.add(board.getCell(rowIndex + rowDelta, columnIndex + columnDelta));
            }
        }
        return returnList;
    }

    @Override
    public String toString()
    {
        return alive ? ALIVE : DEAD;
    }
}

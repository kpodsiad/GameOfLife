package pl.kamil;

import java.util.LinkedList;
import java.util.List;

public class Board
{
    private Cell[][] cells;
    private final int size;

    public Board(int size)
    {
        this.size = size;
        cells = new Cell[size][size];
        initCells();
    }

    private void initCells()
    {
        for (int rowIndex = 0; rowIndex < size; rowIndex++)
        {
            for (int columnIndex = 0; columnIndex < size; columnIndex++)
            {
                cells[rowIndex][columnIndex] = new Cell(rowIndex, columnIndex);
            }
        }
    }

    public List<Cell> getCells()
    {
        List<Cell> returnList = new LinkedList<>();
        for (int rowIndex = 0; rowIndex < size; rowIndex++)
        {
            for (int columnIndex = 0; columnIndex < size; columnIndex++)
            {
                returnList.add(cells[rowIndex][columnIndex]);
            }
        }
        return returnList;
    }

    public Cell getCell(int rowIndex, int columnIndex)
    {
        rowIndex = normalizeIndex(rowIndex);
        columnIndex = normalizeIndex(columnIndex);
        return cells[rowIndex][columnIndex];
    }

    public Board nextGeneration()
    {
        Board board = new Board(size);
        board.initCells();
        for (int rowIndex = 0; rowIndex < size; rowIndex++)
        {
            for (int columnIndex = 0; columnIndex < size; columnIndex++)
            {
                board.cells[rowIndex][columnIndex].setAlive(cells[rowIndex][columnIndex].isChildAlive(this));
            }
        }
        return board;
    }

    public void setAlive(int rowIndex, int columnIndex)
    {
        rowIndex = normalizeIndex(rowIndex);
        columnIndex = normalizeIndex(columnIndex);
        cells[rowIndex][columnIndex].setAlive(true);
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getDash());
        for(var cell : getCells())
        {
            if(cell.getColumnIndex()==0)
            {
                stringBuilder.append("|");
            }
            stringBuilder.append(cell);
            if(cell.getColumnIndex()==size-1)
            {
                stringBuilder.append("|");
                stringBuilder.append(System.lineSeparator());
            }
        }
        stringBuilder.append(getDash());

        return stringBuilder.toString();
    }

    private int normalizeIndex(int index)
    {
        return (index + size) % size;
    }

    private String getDash()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+");
        for (int i = 0; i < size ; i++)
        {
            stringBuilder.append("-");
        }
        stringBuilder.append("+");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }
}

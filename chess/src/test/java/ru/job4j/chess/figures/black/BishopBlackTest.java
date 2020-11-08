package ru.job4j.chess.figures.black;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import ru.job4j.chess.figures.Cell;

public class BishopBlackTest{

    @Test
    public void testPosition() {
        Cell cell = Cell.findBy(0,7);
        BishopBlack bBlack = new BishopBlack(cell);
        assertThat(bBlack.position(), is(cell));

    }

    @Test
    public void testWay() {
        Cell[] cells = new Cell[] {Cell.C1, Cell.G5};
        BishopBlack bBlackSrc = new BishopBlack(cells[0]);
        Cell[] allCells = bBlackSrc.way(cells[1]);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expected, is(allCells));
    }

    @Test
    public void testCopy() {
        Cell cell = Cell.A1;
        Cell cellA2 = Cell.A2;
        BishopBlack bBlack = (BishopBlack) new BishopBlack(cell).copy(cellA2);
        assertThat(bBlack.position(), is(cellA2));
    }

}
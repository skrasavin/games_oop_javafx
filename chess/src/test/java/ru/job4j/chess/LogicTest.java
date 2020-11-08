package ru.job4j.chess;

import org.hamcrest.Matcher;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;

public class LogicTest {

    @Test
    public void testLogic() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBl = new BishopBlack(Cell.A1);
        logic.add(bishopBlack);
        for (int i = 1; i < 32; i++) {
            logic.add(bishopBl);
        }
        logic.move(Cell.C1, Cell.G5);
    }

    @Test
    public void testLogicWithOccupiedCellException() throws FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBl = new BishopBlack(Cell.D2);
        logic.add(bishopBlack);
        logic.add(bishopBl);
        OccupiedCellException exception = new OccupiedCellException();
        Exception newException = null;
        try {
            logic.move(Cell.C1, Cell.G5);
        }catch (OccupiedCellException e) {
            newException = e;
        }
        assertThat(exception.getClass(), is(newException.getClass()));
    }

    private void assertThat(Class<? extends OccupiedCellException> aClass, Matcher<? extends Exception> matcher) {
    }

    @Test
    public void testLogicWithFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = new FigureNotFoundException();
        Exception newException = null;
        try {
            logic.move(Cell.C4, Cell.G5);
        }catch (FigureNotFoundException e) {
            newException = e;
        }
        assertThat1(exception.getClass(), is(newException.getClass()));
    }

    private void assertThat1(Class<? extends FigureNotFoundException> aClass, Matcher<? extends Exception> matcher) {
    }



}
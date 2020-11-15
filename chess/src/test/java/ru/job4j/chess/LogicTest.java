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

    @Test(expected = OccupiedCellException.class)
    public void testLogicWithOccupiedCellException() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBl = new BishopBlack(Cell.D2);
        logic.add(bishopBlack);
        logic.add(bishopBl);
        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testLogicWithFigureNotFound() throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C4, Cell.G5);
    }
}
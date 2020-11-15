package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        int size = Math.abs(dest.getY() - position.getY());

        int srcX = position().getX();
        int srcY = position().getY();
        Cell[] steps = new Cell[size];
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int deltaX = dest.getX() > srcX ? 1: - 1;
        int deltaY = dest.getY() > srcY ? 1: - 1;

        for (int index = 0; index < size; index++) {
            srcX+=deltaX;
            srcY+=deltaY;
            steps[index] = Cell.findBy(srcX, srcY);
        }
        return steps;
    }
    
    /*
                if (dest.getX() > srcX && dest.getY() < srcY) {
                steps[index] = Cell.findBy(++srcX, --srcY);
            }else if (dest.getX() > srcX && dest.getY() > srcY) {
                steps[index] = Cell.findBy(++srcX, ++srcY);
            }else if (dest.getX() < srcX && dest.getY() < srcY) {
                steps[index] = Cell.findBy(--srcX, --srcY);
            }else {
                steps[index] = Cell.findBy(--srcX, ++srcY);
            }
     */
    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.CellType;
import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.exceptions.CellException;
import com.progmatic.labyrinthproject.exceptions.InvalidMoveException;
import com.progmatic.labyrinthproject.interfaces.Player;
import com.progmatic.labyrinthproject.PlayerImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pappgergely
 */
public class LabyrinthImpl implements Labyrinth{

    int width;
    int height;
    PlayerImpl player;
    Player p;
    CellType[][] labyrinthMatrix;

    public LabyrinthImpl() {

    }

    @Override
       public void loadLabyrinthFile(String fileName) throws CellException, FileNotFoundException {
    
        Scanner sc = new Scanner(new File(fileName));
        
        width = Integer.parseInt(sc.nextLine());
        height = Integer.parseInt(sc.nextLine());
        setSize(width, height);
        
        labyrinthMatrix = new CellType[width][height];

        for (int hh = 0; hh < height; hh++) {
            String line = sc.nextLine();
            for (int ww = 0; ww < width; ww++) {
                CellType type = CellType.EMPTY;
                
                switch (line.charAt(ww)) {

                    case 'W': {

                        try {
                            type = CellType.WALL;
                            setCellType(new Coordinate(ww, hh), CellType.WALL);
                            labyrinthMatrix[ww][hh] = CellType.WALL;
                            

                        } catch (CellException ex) {

                        }
                        break;
                    }
                    case 'E': {
                        try {
                            type = CellType.END;
                            setCellType(new Coordinate(ww, hh), CellType.END);
                            labyrinthMatrix[ww][hh] = CellType.END;
                        } catch (CellException ex) {

                        }
                    }
                    break;
                    case 'S': {
                        try {
                            type = CellType.START;
                            setCellType(new Coordinate(ww, hh), CellType.START);
                            labyrinthMatrix[ww][hh] = CellType.START;

                        } catch (CellException ex) {

                        }

                    }
                    break;
                    case ' ': {
                        try {
                            type = CellType.EMPTY;
                            setCellType(new Coordinate(ww, hh), CellType.EMPTY);
                            labyrinthMatrix[ww][hh] = CellType.EMPTY;
                        } catch (CellException ex) {

                        }
                    }
                }
                

                
            }
        }
       }

    @Override
    public int getWidth() {
        if (width == 0) {
            return -1;
        }
        return this.width;
    }

    @Override
    public int getHeight() {
        if (height == 0) {
            return -1;
        }
        return this.height;
    }

    @Override
    public CellType getCellType(Coordinate c) throws CellException {

        if (c.getCol() < 0 || c.getRow() < 0 || c.getCol() >= this.width || c.getRow() >= this.height) {
            throw new CellException(c, "Nincs ilyen mező a labirintusban!");
        }
        int cCol = c.getCol();
        int cRow = c.getRow();
        return labyrinthMatrix[cCol][cRow];

    }

    @Override
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;

    }

    @Override
    public void setCellType(Coordinate c, CellType type) throws CellException {

        if (c.getCol() < 0 || c.getRow() < 0 || c.getCol() >= this.width || c.getRow() >= this.height) {
            throw new CellException(c, "Nincs ilyen mező a labirintusban!");
        }
        
        int cCol = c.getCol();
        int cRow = c.getRow();
        
        labyrinthMatrix[cCol][cRow] = type;

        if (type.equals(CellType.START))
        {
            //PLAYER SETPOSITION
        } 
    }

    @Override
    public Coordinate getPlayerPosition() {

        return player.getPosition();

    }

    @Override
    public boolean hasPlayerFinished() {
        return getPlayerPosition().getCt().equals("END");

    }

    @Override
    public List<Direction> possibleMoves() {
        int col = p.GetPosition().getCol();
        int row = p.GetPosition().getRow();
        ArrayList<Direction> possibleMovesList = new ArrayList<>();
        Coordinate currentPosition = new Coordinate(col, row);

        if (new Coordinate((currentPosition.getCol() + 1), row).getCt().equals(CellType.EMPTY)
                || (new Coordinate((currentPosition.getCol() + 1), row).getCt().equals(CellType.END))) {
            possibleMovesList.add(Direction.EAST);

        } else if (new Coordinate((currentPosition.getCol() - 1), row).getCt().equals(CellType.EMPTY)
                || (new Coordinate((currentPosition.getCol() - 1), row).getCt().equals(CellType.END))) {

            possibleMovesList.add(Direction.WEST);

        } else if (new Coordinate(col, (currentPosition.getRow() + 1)).getCt().equals(CellType.EMPTY)
                || (new Coordinate(col, (currentPosition.getRow() + 1)).getCt().equals(CellType.END))) {

            possibleMovesList.add(Direction.SOUTH);

        } else if (new Coordinate(col, (currentPosition.getRow() + 1)).getCt().equals(CellType.EMPTY)
                || (new Coordinate(col, (currentPosition.getRow() + 1)).getCt().equals(CellType.END))) {

            possibleMovesList.add(Direction.NORTH);

        }

        return possibleMovesList;
    }

    @Override
    public void movePlayer(Direction direction)  {

        switch (direction) {
            case EAST:
                p.SetPosition(new Coordinate((p.GetPosition().getRow()), (p.GetPosition().getRow() + 1)));
            case WEST:
                p.SetPosition(new Coordinate((p.GetPosition().getRow()), (p.GetPosition().getRow() - 1)));
            case NORTH:
                p.SetPosition(new Coordinate((p.GetPosition().getRow() + 1), (p.GetPosition().getRow())));
            case SOUTH:
                p.SetPosition(new Coordinate((p.GetPosition().getRow() - 1), (p.GetPosition().getRow())));
        }

        if ((p.GetPosition().getCt().equals(CellType.WALL))
                || (p.GetPosition().getCt().equals(CellType.START))) {
        }

    }

}

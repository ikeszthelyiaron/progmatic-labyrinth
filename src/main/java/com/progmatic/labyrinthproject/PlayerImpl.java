
package com.progmatic.labyrinthproject;

import com.progmatic.labyrinthproject.enums.Direction;
import com.progmatic.labyrinthproject.interfaces.Labyrinth;
import com.progmatic.labyrinthproject.interfaces.Player;


public  class PlayerImpl implements Player {
    
    public Coordinate position;
    public int z;
    
    
    
    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    @Override
    public Direction nextMove(Labyrinth l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordinate position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetPosition(Coordinate c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordinate GetPosition() {
        return this.position;
    }


    
    
    
    
    
    }
    
    
    
    



import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    int myX;
    int myY;
    int myTransparency=255;
    
    
    /**
     * Act - do whatever the Square wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 
    public Square(){
        myTransparency=0;
        myX=1;
        myY=1;
        GreenfootImage sq = new GreenfootImage(20,20);
        sq.setColor(Color.BLACK); 
        sq.setTransparency(myTransparency); // 0-255
        sq.fill();
        setImage(sq);
    }
    public Square(int t){
        myTransparency=t;
        myX=1;
        myY=1;
        GreenfootImage sq = new GreenfootImage(20,20);
        sq.setColor(Color.BLACK); 
        sq.setTransparency(myTransparency); // 0-255
        sq.fill();
        setImage(sq);
    }
    public Square(int t,int x,int y){
        myTransparency=t;
        myX=x;
        myY=y;
        GreenfootImage sq = new GreenfootImage(20,20);
        sq.setColor(Color.BLACK); 
        sq.setTransparency(myTransparency); // 0-255
        sq.fill();
        setImage(sq);
    }
    public void setMyX(int x){
        myX=x;
    }
    public void setMyY(int y){
        myY=y;
    }
    public int getMyX(){
        return myX;
    }
    public int getMyY(){
        return myY;
    }  
    public int getTransparency(){
        return myTransparency;
    }   
    public void act() 
    {
        // Add your action code here.
    }    
}

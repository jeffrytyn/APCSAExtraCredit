import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

  
    private int sz=5; // You can assume that the 2D grids are square, sz x sz
    
    private Square[][] grid2d=new Square[sz][sz];
    private Square[][] grid2dIdentity=new Square[sz][sz]; // use for creating an exact copy
    private Square[][] grid2dAve=new Square[sz][sz];      // use to create a grid where transparency is average of all squares
                                                          // from original grid2d
    private Square[][] grid2dSplitDiag=new Square[sz][sz];  // diag is ave of all values on diaganal. above if average of all values above diag
                                                            // below is average of all values below diag
    private Square[] rowAve =new Square[sz];  // a row of squares where each value is the average transparency of the squares in a column
                                              // You must write a method that takes a 2D array and returns a 1D array of squares.                                                         
  
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 30x30 cells with a cell size of 20 pixels.

       super(30, 30, 20);    
       
       // The following is provided to the student as an example.  Note the duplicateGrid method. You will need to study this to 
       // complete 1-5 below.  Use the drawGrid method as a template to create a similar method drawRow.
       
       grid2d=createGrid(sz);
       drawGrid(grid2d, 0, 0);
       grid2dIdentity = duplicateGrid(grid2d);
       drawGrid(grid2dIdentity, 7,0);
       grid2dSplitDiag = grid2dDiag(grid2d);
       drawGrid(grid2dSplitDiag, 0, -7);
       grid2dAve = grid2dAve(grid2d);
       drawGrid(grid2dAve, 14, 0);
       rowAve = grid2dToRowAve(grid2d);
       drawRow(rowAve, 15, 15);

       // To be implemented by student
       
       // 1) Write a method that takes a 2D square array as input and returns a 2D square array where all transparencies are the average  of all values from the original
       // 2) draw the return array at offset 14,0 using the method drawGrid
       // 3) Write the method that takes the original grid2d as input and returns the grid2dSplitDiag grid
       // 4) Draw the grid2dSplitDiag grid at offset 0, 7
       // 5) Write a method that takes the original grid2d as input and returns an array rowAve as explained above
       // 6) Write a method drawRow, similar to drawGrid, that just draws the 1D array across the x axis, at a specified x and y offset
       // 7) Use the drawRow method to draw the rowAve array at offset 15,15
       
    }
    
    public Square[][] createGrid(int sz){ 
       Square[][] a2d = new Square[sz][sz];
       for (int i=0;i<sz;i++){
          for (int j=0;j<sz;j++){
              a2d[i][j]=new Square((int)(Math.random()*230)+25);
            }
        }
        return a2d;   
    }
    
    public Square[][] duplicateGrid(Square[][] g){
      Square[][] d = new Square[sz][sz];
      int t;
      for (int i=0;i<sz;i++){
          for (int j=0;j<sz;j++){   
             // d[i][j]=g[i][j];// This won't work because it is creating a reference
                t = g[i][j].getTransparency();
                d[i][j]=new Square(t); 
                
            }
        }
        return d;
    }
   
   public void drawGrid(Square[][] g, int xOff, int yOff){
    for (int i=0;i<sz;i++){
            for (int j=0;j<sz;j++){
                g[i][j].setMyX((i)+xOff);
                g[i][j].setMyY((j)+yOff);
                addObject(g[i][j],g[i][j].getMyX(),g[i][j].getMyY());
            }
        }
    }
    public void drawRow(Square[] g, int xOff, int yOff){
      for (int i=0;i<g.length;i++){
            g[i].setMyX((i) + xOff);
            addObject(g[i], g[i].getMyX(), yOff);
        }
    }
   // This is a sample method that just moves a grid +/- in the x axis
   public void grid2dMoveX(int x){
       for (int i = 0;i<sz;i++){
           for (int j=0;j<sz;j++){
               grid2d[i][j].setMyX(grid2d[i][j].getMyX()+x);
               grid2d[i][j].setLocation(grid2d[i][j].getMyX(),grid2d[i][j].getMyY());
            }
        }
    }
   public Square[][] grid2dAve(Square[][] g){
      Square[][] d = new Square[g.length][g[0].length];
      int sum = 0;
      int ave = 0;
      for (int i=0;i<g.length;i++){
          for (int j=0;j<g[i].length;j++){   
                sum += g[i][j].getTransparency(); 
            }
        }
      ave = sum/(g.length * g[0].length);
      for (int i=0;i<g.length;i++){
          for (int j=0;j<g[i].length;j++){    
              d[i][j]= new Square(ave);
            }
        }
        return d;
    }
    public Square[][] grid2dDiag(Square[][]g){
        Square[][]d = new Square[sz][sz];
        int sum = 0;
        int ave = 0;
        for (int i=0;i<sz;i++){
          for (int j=0;j<sz;j++){   
                sum += g[i][j].getTransparency(); 
            }
        }
        ave = sum/(g.length * g[0].length);
        for(int i = 0; i < sz; i++){
          d[i][i] = new Square(ave);
        }
        
        for(int i = 0; i<sz; i++){
            for(int j = 0; j<sz; j++){
                if(g[i][j].getTransparency() < ave){
                    
                }
            }
        }
        return d;
    }
   public Square[] grid2dToRowAve(Square[][] g){
      Square[] d = new Square[g[0].length];
      int sum = 0;
      for (int i=0;i<g.length;i++){
          for (int j=0;j<g[0].length;j++){   
                sum += g[i][j].getTransparency();
            }
          int ave = (sum/(g.length));
          d[i] = new Square(ave);
          sum = 0;
        }
      return d;
    }
}

public class GraphicsManager
{
  private char[][] board=new char[100][100];

  public GraphicsManager()
  {
    clearBoard();
  }

  public void drawText(String s)
  {
    System.out.println(s);
  }

  public void preRender()
  {
    clearBoard();
  }

  public void postRender()
  {
    drawBoard();
  }

  public void clearBoard()
  {
    for(int i=0;i<board.length;i++)
    {
      for(int j=0;j<board[i].length;j++)
      {
        board[i][j]=' ';
      }
    }
  }

  public void drawBoard()
  {
    String retval="";
    for(int i=0;i<board.length;i++)
    {
      for(int j=0;j<board[i].length;j++)
      {
        retval+=board[i][j]; 
      }
      retval+="\n";
    }
    System.out.println(retval);
  }

  public void addToBoard(int x,int y,char value)
  {
    try
    {
      board[y][x]=value;
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      //do nothing
    }
  }
}

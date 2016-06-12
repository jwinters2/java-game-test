import java.util.ArrayList;

public class World
{
  private ArrayList<WorldObject> objList=new ArrayList<WorldObject>();
  private long frame;

  public World()
  {
    frame=0;
  }

  public void worldLogic()
  {
    frame++;

    int size=objList.size();
    //this is to prevent bugs caused by the arraylist changing size mid-loop

    for(int i=0;i<size;i++)
    {
      objList.get(i).logic(this);
    }
  }

  public void worldRender(GraphicsManager g)
  {
    this.preRender(g);
    g.preRender();

    for(int i=0;i<objList.size();i++)
    {
      objList.get(i).render(g);
    }

    g.postRender();
  }
    
  public boolean isStillRunning()
  {
    return true;
  }

  public void addObject(WorldObject obj)
  {
    objList.add(obj);
  }

  private void preRender(GraphicsManager g)
  {
    g.drawText("Starting Render: Frame="+frame);
  }

  public WorldObject listGet(int i)
  {
    return objList.get(i);
  }

  public int listSize()
  {
    return objList.size();
  }
}

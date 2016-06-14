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
    //this is to prevent bugs caused by the ArrayList changing size mid-loop

    for(int i=0;(i<size && i<objList.size());i++)
    {
      objList.get(i).logic(this);
    }

    objList.trimToSize();
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
    g.drawText("Starting Render: Frame="+frame+"\tObjectsCount="+objList.size());
  }

  public WorldObject listGet(int i)
  {
    return objList.get(i);
  }

  public int listSize()
  {
    return objList.size();
  }

  public void removeObject(WorldObject ob)
  {
    objList.remove(ob);
    ob=null;
  }

  public void removeObject(int id)
  {
    for(int i=0;i<objList.size();i++)
    {
      if(objList.get(i).getId()==id)
      {
        objList.set(i,null);
        objList.remove(i);
        return;
      }
    }
  }
}

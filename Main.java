public class Main
{
  public static void main(String[] args)
  {
    GraphicsManager g=new GraphicsManager();
    World w=new World();
    w.addObject(new WorldObject().randomize());

    while(w.isStillRunning())
    {
      w.worldLogic();
      w.worldRender(g);
    }
  }
}

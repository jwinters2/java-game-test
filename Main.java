public class Main
{
  public static void main(String[] args)
  {
    GraphicsManager g=new GraphicsManager();
    World w=new World();

    while(w.isStillRunning())
    {
      w.addObject(new WorldObject().randomize());
      w.worldLogic();
      w.worldRender(g);
    }
  }
}

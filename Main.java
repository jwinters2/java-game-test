public class Main
{
  public static void main(String[] args)
  {
    GraphicsManager g=new GraphicsManager();
    World w=new World();
    
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());
    w.addObject(new Anchor().randomize());

    while(w.isStillRunning())
    {
      w.addObject(new WorldObject().randomize());
      w.worldLogic();
      w.worldRender(g);
    }
  }
}

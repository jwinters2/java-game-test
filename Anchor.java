public class Anchor extends WorldObject
{
  public Anchor()
  {
    
  }

  @Override
  public WorldObject randomize()
  {
    pos=new Coord<Double>(randomDouble(45,55),randomDouble(45,55),randomDouble(45,55));
    vel=new Coord<Double>(0.0,0.0,0.0);
    
    return this;
  }

  @Override
  public void logic(World w)
  {
  }

  /*
  public void render(GraphicsManager g)
  {
    g.drawText(""+id);
    super.render(g);
  }
  */
}

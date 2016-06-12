import java.util.Random;
import java.util.ArrayList;

public class WorldObject
{
  private static int idGenerator=0;
  private Coord<Double> pos;
  private Coord<Double> vel;
  private int id;

  public WorldObject()
  {
    pos=new Coord<Double>(0.0,0.0,0.0);
    vel=new Coord<Double>(0.0,0.0,0.0);
    
    id=assignId(); 
  }

  public WorldObject(double x_,double y_,double z_)
  {
    pos=new Coord<Double>(x_,y_,z_);
    vel=new Coord<Double>(0.0,0.0,0.0);
    
    id=assignId(); 
  }

  public WorldObject(Coord a)
  {
    pos=new Coord<Double>(a);
    vel=new Coord<Double>(0.0,0.0,0.0);

    id=assignId(); 
  }

  public int getId()
  {
    return id;
  }

  public Coord<Double> getPos()
  {
    return new Coord<Double>(pos);
  }

  public void setPos(Coord<Double> pos_)
  {
    pos=new Coord<Double>(pos_);
  }

  public Coord<Double> getVel()
  {
    return new Coord<Double>(vel);
  }

  public void setVel(Coord<Double> vel_)
  {
    vel=new Coord<Double>(vel_);
  }

  public void logic(World w)
  {
    for(int i=0;i<w.listSize();i++)
    {
      if(id != w.listGet(i).getId())
      {
        Coord<Double> dpos=Coord.addD(pos,Coord.mul(w.listGet(i).getPos(),-1));
        //dpos = this.pos - other.pos

        vel=Coord.addD(vel,Coord.mul(dpos,-Math.pow(Coord.dist(pos,w.listGet(i).getPos()),-2)));
      }
    }

    pos.setX(pos.getX()+vel.getX());
    pos.setY(pos.getY()+vel.getY());
    pos.setZ(pos.getZ()+vel.getZ());

    vel=Coord.mul(vel,0.999);
  }

  public boolean collides(WorldObject o)
  {
    if(o.getId()==id)
    {
      return false;
    }

    Coord<Double> otherPos=o.getPos();
    if(pos.getX()==otherPos.getX() && pos.getY()==otherPos.getY())
    {
      return true;
    }

    return false;
  }

  public void stopMovement()
  {
    vel=new Coord<Double>(0.0,0.0,0.0);
  }

  public void render(GraphicsManager g)
  {
    //g.drawText(pos.getX()+"\t"+pos.getY());
    g.addToBoard(pos.getX().intValue(),pos.getY().intValue(),'X');
  }

  public WorldObject randomize()
  //randomizes pos and vel, then return this object
  {
    //pos=new Coord<Double>(randomDouble(0,100),randomDouble(0,100),randomDouble(0,100));
    pos=new Coord<Double>(50.0,50.0,50.0);
    vel=new Coord<Double>(randomDouble(-5,5), randomDouble(-5,5), randomDouble(-5,5));
    
    return this;
  }

  private double randomDouble(double min,double max)
  {
    Random rand=new Random();

    double retval=(max-min)*rand.nextDouble();
    //any double

    if(retval<0)
    {
      retval=-retval;
    }
    //positive double

    return retval+min;
  }

  protected int assignId()
  {
    int retval=idGenerator;
    idGenerator++;
    return retval;
  }
}

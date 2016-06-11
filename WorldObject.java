import java.util.Random;
import java.util.ArrayList;

public class WorldObject
{
  private static int idGenerator=0;
  private Coord<Integer> pos;
  private Coord<Integer> vel;
  private int id;

  public WorldObject()
  {
    pos=new Coord<Integer>(0,0,0);
    vel=new Coord<Integer>(0,0,0);
    
    id=assignId(); 
  }

  public WorldObject(int x_,int y_,int z_)
  {
    pos=new Coord<Integer>(x_,y_,z_);
    vel=new Coord<Integer>(0,0,0);
    
    id=assignId(); 
  }

  public WorldObject(Coord a)
  {
    pos=new Coord<Integer>(a);
    vel=new Coord<Integer>(0,0,0);

    id=assignId(); 
  }

  public int getId()
  {
    return id;
  }

  public Coord<Integer> getPos()
  {
    return new Coord<Integer>(pos);
  }

  public void setPos(Coord<Integer> pos_)
  {
    pos=new Coord<Integer>(pos_);
  }

  public Coord<Integer> getVel()
  {
    return new Coord<Integer>(vel);
  }

  public void setVel(Coord<Integer> vel_)
  {
    vel=new Coord<Integer>(vel_);
  }

  public void logic(World w)
  {
    if(id==0)//only the first object can make more
    {
      WorldObject n=new WorldObject().randomize();
      n.setPos(pos);
      w.addObject(n);
    }


    pos.setX(pos.getX()+vel.getX());
    pos.setY(pos.getY()+vel.getY());
    pos.setZ(pos.getZ()+vel.getZ());

    while(pos.getX()>=100)
    {
      pos.setX(pos.getX()-100);
    }

    while(pos.getY()>=100)
    {
      pos.setY(pos.getY()-100);
    }

    while(pos.getZ()>=100)
    {
      pos.setZ(pos.getZ()-100);
    }

    while(pos.getX()<0)
    {
      pos.setX(pos.getX()+100);
    }

    while(pos.getY()<0)
    {
      pos.setY(pos.getY()+100);
    }

    while(pos.getZ()<0)
    {
      pos.setZ(pos.getZ()+100);
    }

    for(int i=0;i<w.listSize();i++)
    {
      if(this.collides(w.listGet(i)))
      {
        this.stopMovement();
        w.listGet(i).stopMovement();
      }
    }
  }

  public boolean collides(WorldObject o)
  {
    if(o.getId()==id || id==0)
    {
      return false;
    }

    Coord<Integer> otherPos=o.getPos();
    if(pos.getX()==otherPos.getX() && pos.getY()==otherPos.getY())
    {
      return true;
    }

    return false;
  }

  public void stopMovement()
  {
    vel=new Coord<Integer>(0,0,0);
  }

  public void render(GraphicsManager g)
  {
    g.addToBoard(pos.getX(),pos.getY(),'X');
  }

  public WorldObject randomize()
  //randomizes pos and vel, then return this object
  {
    pos=new Coord<Integer>(randomInt(0,100),randomInt(0,100),randomInt(0,100));
    vel=new Coord<Integer>(randomInt(-3,3), randomInt(-3,3), randomInt(-3,3));
    //vel=new Coord<Integer>(randomInt(-5,5), randomInt(-5,5), randomInt(-5,5));
    
    return this;
  }

  private int randomInt(int min,int max)
  {
    Random rand=new Random();

    int retval=rand.nextInt();
    //any int

    if(retval<0)
    {
      retval=-retval;
    }
    //positive int

    retval%=(max-min);
    //int from 0 to max-min

    return retval+min;
  }

  protected int assignId()
  {
    int retval=idGenerator;
    idGenerator++;
    return retval;
  }
}

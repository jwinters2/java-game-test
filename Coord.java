import java.util.Random;

public class Coord<T>
{
  private T x;
  private T y;
  private T z;

  public Coord()
  {
  }

  public Coord(T x_,T y_,T z_)
  { 
    x=x_;
    y=y_;
    z=z_;
  }

  public Coord(Coord o)
  { 
    x=(T)o.getX();
    y=(T)o.getY();
    z=(T)o.getZ();
  }

  public T getX()
  {
    return x;
  }

  public T getY()
  {
    return y;
  }

  public T getZ()
  {
    return z;
  }

  public void setX(T x_)
  {
    x=x_;
  }

  public void setY(T y_)
  {
    y=y_;
  }

  public void setZ(T z_)
  {
    z=z_;
  }
}

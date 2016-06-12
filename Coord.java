import java.util.Random;
import java.lang.Math;

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

  public static Coord<Double> addD(Coord<Double> a,Coord<Double> b)
  {
    return new Coord<Double>(a.getX()+b.getX(),a.getY()+b.getY(),a.getZ()+b.getZ());
  }

  public static Coord<Integer> addI(Coord<Integer> a,Coord<Integer> b)
  {
    return new Coord<Integer>(a.getX()+b.getX(),a.getY()+b.getY(),a.getZ()+b.getZ());
  }

  public static Coord<Double> mul(Coord<Double> a,double m)
  {
    return new Coord<Double>(a.getX()*m,a.getY()*m,a.getZ()*m);
  }

  public static Coord<Integer> mul(Coord<Integer> a,int m)
  {
    return new Coord<Integer>(a.getX()*m,a.getY()*m,a.getZ()*m);
  }

  public static double dist(Coord<Double> a,Coord<Double> b)
  {
    double dx=a.getX()-b.getX();
    double dy=a.getY()-b.getY();
    double dz=a.getZ()-b.getZ();
    return Math.sqrt((dx*dx)+(dy*dy)+(dz*dz));
  }
}

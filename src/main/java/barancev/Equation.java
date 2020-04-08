package barancev;

public class Equation {
  double a;
  double b;
  double c;

  int n;

  public Equation(double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;

    double d = b*b - 4*a*c;

    if (d > 0){
      n = 2;
    } else {
      if (d == 0){
        n = 1;
      } else {
        n = 0;
      }
    }
  }

  public int rootNumber(){
    return n;
  }
}

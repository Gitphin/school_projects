
public class Rational {

public int num;
public int den;

  public Rational(int numerator, int denominator) {
    num = numerator;
    den = denominator;
}
  public int getNumerator() {

    return num;
  }
  public int getDenominator() {

    return den;
  }
  public void setNumerator(int numerator) {

    num = numerator;
  }
  public void setDenominator(int denominator) {

    den = denominator;
  }
  public void addRational(Rational r) {
    num = (num * r.getDenominator()) + (den * r.getNumerator());
    den = (den * r.getDenominator());
    System.out.println(num + "/" + den);

  }
  public void subRational(Rational r) {
    num = (num * r.getDenominator()) - (den * r.getNumerator());
    den = (den * r.getDenominator());
    System.out.println(num + "/" + den);

  }
  public void mulRational(Rational r) {
    num = (num * r.getNumerator());
    den = (den * r.getDenominator());
    System.out.println(num + "/" + den);

  }
  public void divRational(Rational r) {
    num = (num * r.getDenominator());
    den = (den * r.getNumerator());
    System.out.println(num + "/" + den);


  }

public static void main(String[] args) {
    Rational test = new Rational(4,7);

    test.addRational();



}







}

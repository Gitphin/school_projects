private int data;
public Whatever(int data) {
    this.data = data;
}
public void setData(int newData) {
    data = newData;
}
/////////////////////////////////////////////
Scanner s = new Scanner(System.in);
int sum = 0;
while (s.hasNext()) {
    String data = s.next();
    if (data.equals("stop")) {
        break;
    }
    sum += Integer.parseInt(data);
}
System.out.println("The sum is: " + sum);
/////////////////////////////////////////////
Object a = new Object();
Object b = new Object();
Object c = null;
boolean b1 = a.equals(b); // False
boolean b2 = b.equals(c); // False
boolean b3 = c.equals(a); // Error
boolean b4 = (a == null || c == null) || c.equals(b); // True
package Classwork4;


public class Task1 {

    public static void main(String[] args) {
        Polynom[] polys = new Polynom[4];
        polys[0] = new Polynom(1, 2, 3, 4);
        polys[1] = new Polynom(1, 2, 1, 4);
        polys[2] = new Polynom(1,3);
        polys[3] = new Polynom(1,4,1,3,1,3);
        Polynom pSum = Polynom.Add(polys[0], polys[1]);
        pSum = Polynom.Add(pSum, polys[2]);
        pSum = Polynom.Add(pSum, polys[3]);
        System.out.println(pSum);
    }
}

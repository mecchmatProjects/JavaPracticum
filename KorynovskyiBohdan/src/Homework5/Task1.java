/*
    4.13.Створити об`єкт класу Одномерний массів, використовуючи класи Масив,Елемент.
    Методи: створити, вивести на консоль, виконати операції (скласти, відняти, помножити).
 */

package Homework5;

class Element {
    int el;

    Element() {
        el = 0;
    }

    Element(int el) {
        this.el = el;
    }

    int getEl() {
        return el;
    }

    @Override
    public String toString() {
        return String.format("%d", el);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Element)) return false;

        Element el = (Element) obj;
        return this.el == el.getEl();
    }

    @Override
    public int hashCode() {
        return 2 * el + 21;
    }

    public Element plus(Element el) {
        return new Element(this.getEl() + el.getEl());
    }

    public Element minus(Element el) {
        return new Element(this.getEl() - el.getEl());
    }

    public Element multiplication(Element el) {
        return new Element(this.getEl() * el.getEl());
    }
}

class Array {
    Element[] arr;

    Array() {
        arr = new Element[]{new Element()};
    }

    Array(int n) {
        arr = new Element[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Element();
        }
    }

    Array(Element[] args) {
        arr = args;
    }

    public Array getArr() {
        return new Array(arr);
    }

    public Element[] getElements() {
        return arr;
    }

    @Override
    public String toString() {
        String str = "";
        for (Element el : arr) {
            str += el.toString() + " ";
        }

        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Array)) return false;

        Array arr = (Array) obj;

        return this.hashCode() == arr.hashCode();
    }

    @Override
    public int hashCode() {
        return arr.length;
    }
}

class Vector {
    Array vector;

    Vector() {
        vector = new Array();
    }

    Vector(int[] arr) {
        Element[] res = new Element[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = new Element(arr[i]);
        }

        vector = new Array(res);
    }

    Vector(int n) {
        vector = new Array(n);
    }

    public Array getVector() {
        return vector.getArr();
    }

    public void print() {
        System.out.println(vector.toString());
    }

    @Override
    public int hashCode() {
        return this.getVector().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector)) return false;

        Vector arr = (Vector) obj;

        return this.hashCode() == arr.hashCode();
    }

    public Vector plus(Object obj) {
        if (!this.equals(obj)) {
            return new Vector();
        }

        Vector arr = (Vector) obj;

        Vector res = new Vector(arr.hashCode());
        for (int i = 0; i < this.hashCode(); i++) {
            res.getVector().getElements()[i] = this.getVector().getElements()[i].plus(arr.getVector().getElements()[i]);

        }

        return res;
    }

    public Vector minus(Object obj) {
        if (!this.equals(obj)) {
            return new Vector();
        }

        Vector arr = (Vector) obj;

        Vector res = new Vector(arr.hashCode());
        for (int i = 0; i < this.hashCode(); i++) {
            res.getVector().getElements()[i] = this.getVector().getElements()[i].minus(arr.getVector().getElements()[i]);

        }

        return res;
    }

    public Vector multiplication(Object obj) {
        if (!this.equals(obj)) {
            return new Vector();
        }

        Vector arr = (Vector) obj;

        Vector res = new Vector(arr.hashCode());
        for (int i = 0; i < this.hashCode(); i++) {
            res.getVector().getElements()[i] = this.getVector().getElements()[i].multiplication(arr.getVector().getElements()[i]);

        }

        return res;
    }

}

public class Task1 {
    public static void main(String[] args) {
        int[] array1 = new int[]{2, 3, 5, 1, 12, 22, 46};
        Vector vector1 = new Vector(array1);

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        Vector vector2 = new Vector(array2);

        Vector vector3 = vector1.plus(vector2);
        vector3.print();

        int[] array4 = new int[]{1, 2, 3};
        Vector vector4 = new Vector(array4);

        vector3 = vector1.plus(vector4);
        vector3.print();

        vector3 = vector1.minus(vector2);
        vector3.print();

        vector3 = vector1.multiplication(vector2);
        vector3.print();
    }
}

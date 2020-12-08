package Homework8;

class Cube {
    private int a;
    private String color;
    private String mat;

    Cube(String[] str) {
        this.a = (Integer.parseInt(str[0]));
        this.color = str[1];
        this.mat = str[2];
    }

    public int getA() {
        return this.a;
    }

    public String getColor() {
        return this.color;
    }

    public String getMat() {
        return this.mat;
    }


}

package Homework9ser;

import Classwork9ser.Passenger;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Polynom implements Serializable {
    ArrayList<Float> coeffs;
    ArrayList<Float> der_coeffs;
    ArrayList<Float> int_coeffs;
    ArrayList<Float> simple_coeffs;
    ArrayList<Integer> powers;
    ArrayList<Integer> der_powers;
    ArrayList<Integer> int_powers;
    ArrayList<Integer> simple_powers;

    Polynom() {
        coeffs = new ArrayList<>();
        powers = new ArrayList<>();
        der_coeffs = new ArrayList<>();
        der_powers = new ArrayList<>();
        int_coeffs = new ArrayList<>();
        int_powers = new ArrayList<>();
        simple_coeffs = new ArrayList<>();
        simple_powers = new ArrayList<>();
    }

    Polynom(ArrayList<Float> coeffs, ArrayList<Integer> powers) {
        this.coeffs = new ArrayList<>(coeffs);
        this.powers = new ArrayList<>(powers);
        der_coeffs = new ArrayList<>();
        der_powers = new ArrayList<>();
        int_coeffs = new ArrayList<>();
        int_powers = new ArrayList<>();
        simple_coeffs = new ArrayList<>();
        simple_powers = new ArrayList<>();

        sortCoeffs();

        for (int i = 1; i < coeffs.size(); i++) {
            der_coeffs.add(this.coeffs.get(i) * this.powers.get(i));
            der_powers.add(this.powers.get(i) - 1);
        }

        for (int i = 0; i < coeffs.size(); i++) {
            int_coeffs.add(this.coeffs.get(i) / (this.powers.get(i) + 1));
            int_powers.add(this.powers.get(i) + 1);
        }
    }

    void simplifyPoly() {
        int n = size();
        int p = 0;

        ArrayList<Float> newCoeffs = new ArrayList<>();
        ArrayList<Integer> newPowers = new ArrayList<>();

        while (n > 0) {
            float tmpCoeffsSum = 0.f;

            for (int i = 0; i < size(); i++) {
                if (powers.get(i) == p) {
                    tmpCoeffsSum += coeffs.get(i);
                    n--;
                }
            }

            newCoeffs.add(tmpCoeffsSum);
            newPowers.add(p);
            p++;
        }

        coeffs = new ArrayList<>(newCoeffs);
        powers = new ArrayList<>(newPowers);
    }

    Polynom derivative() {
        Polynom der_poly = new Polynom(der_coeffs, der_powers);
        return der_poly;
    }

    int size() {
        return coeffs.size();
    }

    Polynom Integral() {
        Polynom int_poly = new Polynom(int_coeffs, int_powers);
        return int_poly;
    }

    void sortCoeffs() {
        int n = coeffs.size();
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (powers.get(i) > powers.get(i + 1)) {
                    Collections.swap(powers, i, i + 1);
                    Collections.swap(coeffs, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    int MaxPow(){
        int n=size()-1;
        return powers.get(n);
    }

    float PolynomValue(float x) {
        float sum = 0.f;
        for (int i = 0; i < size(); i++) {
            sum += Math.pow(x, powers.get(i)) * coeffs.get(i);
        }
        return sum;
    }

    Polynom add(Polynom other){
        int l1=size(), l2=other.size();
        int max_d = Math.max(l1, l2);

        ArrayList<Float> newCoeffs = new ArrayList<>();
        ArrayList<Integer> newPowers = new ArrayList<>();

        float [] arrCoeffs = new float[max_d];
        for (int i=0; i < max_d; i++) {
            arrCoeffs[i] = 0.f;
            if (i < l1) arrCoeffs[i] += coeffs.get(i);
            if (i < l2) arrCoeffs[i] += other.coeffs.get(i);

            newCoeffs.add(arrCoeffs[i]);
            newPowers.add(i);
        }

        Polynom resPoly = new Polynom(newCoeffs, newPowers);
        return resPoly;
    }


    Polynom subtract(Polynom other){
        int l1=size(), l2=other.size();
        int max_d = Math.max(l1, l2);

        ArrayList<Float> newCoeffs = new ArrayList<>();
        ArrayList<Integer> newPowers = new ArrayList<>();

        float [] arrCoeffs = new float[max_d];
        for (int i=0; i < max_d; i++) {
            arrCoeffs[i] = 0.f;
            if (i < l1) arrCoeffs[i] += coeffs.get(i);
            if (i < l2) arrCoeffs[i] -= other.coeffs.get(i);

            newCoeffs.add(arrCoeffs[i]);
            newPowers.add(i);
        }

        Polynom resPoly = new Polynom(newCoeffs, newPowers);
        return resPoly;
    }



    Polynom multiplication(Polynom other){
        int l1=size(), l2=other.size();
        ArrayList<Float> new_coeffs = new ArrayList<>();
        ArrayList<Integer> new_powers = new ArrayList<>();
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                new_coeffs.add(coeffs.get(i)*other.coeffs.get(j));
                new_powers.add(powers.get(i)+other.powers.get(j));
            }
        }
        Polynom multiply = new Polynom(new_coeffs,new_powers);
        multiply.sortCoeffs();
        multiply.simplifyPoly();
        return multiply;
    }



    @Override
    public String toString() {
        String out = "";

        for (int i = size() - 1; i > 0; i--) {
            String sign = (coeffs.get(i - 1) > 0) ? " + " : " - ";
            out += Math.abs(coeffs.get(i)) + ((powers.get(i) == 1) ? "x" : ("x^" + powers.get(i))) + sign;
        }
        if (powers.get(0) > 0) {
            out += Math.abs(coeffs.get(0)) + ((powers.get(0) == 1) ? "x" : ("x^" + powers.get(0)));
        } else {
            out += Math.abs(coeffs.get(0));
        }

        return out;

    }
}

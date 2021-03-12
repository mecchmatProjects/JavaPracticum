package Homework10;

import java.util.ArrayList;

public class Graph {
    protected ArrayList<Integer> tops;
    protected int amount;
    protected ArrayList<ArrayList<Integer>> ribs;

    Graph(int amount){
        this.tops = new ArrayList<>();
        this.ribs = new ArrayList<>();
        this.amount = amount;
        for(int i=0;i<amount;i++){
            this.tops.add(i+1);
        }
    }

    void AddRib(int a,int b){
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(a);
        tmp.add(b);
        if(tmp.get(0)<=this.amount&& tmp.get(0)>0&&tmp.get(1)<=this.amount&& tmp.get(1)>0){
            this.ribs.add(tmp);
        }
    }

    void RemoveRib(int a, int b){
        ArrayList<Integer> tmp1 = new ArrayList<>();
        tmp1.add(a);
        tmp1.add(b);
        ArrayList<Integer> tmp2 = new ArrayList<>();
        tmp2.add(b);
        tmp2.add(a);

        this.ribs.removeIf(x -> x.equals(tmp1)||x.equals(tmp2));
    }

    void PrintRibs(){
        System.out.println("All ribs: ");
        for(ArrayList<Integer> x:this.ribs){
            System.out.println(x.get(0)+"->"+x.get(1));
        }
    }


    void PrintConnectios(int a){
        ArrayList<Integer> result = new ArrayList<>();
        if(a>0&&a<=amount){
            for(ArrayList<Integer> x:this.ribs){
                if(x.get(0)==a){
                    result.add(x.get(1));
                }
                else if(x.get(1)==a){
                    result.add(x.get(0));
                }
            }

            System.out.println("Top '"+a+"' connected with: ");
            for(Integer x:result){
                System.out.print(x+" ");
            }
        }
    }

}

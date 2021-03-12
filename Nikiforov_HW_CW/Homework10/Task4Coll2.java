package Homework10;

public class Task4Coll2 {
    public static void main(String[] args) {
        Graph gr = new Graph(6);
        gr.AddRib(1,2);
        gr.AddRib(1,4);
        gr.AddRib(1,6);
        gr.AddRib(3,1);
        gr.AddRib(2,4);
        gr.AddRib(5,2);
        gr.AddRib(6,3);
        gr.AddRib(4,3);
        gr.AddRib(4,4);
        gr.AddRib(1,5);

        gr.PrintRibs();
        System.out.println("\n\n");

        gr.RemoveRib(3,4);
        gr.RemoveRib(1,5);
        gr.RemoveRib(4,4);
        gr.RemoveRib(2,4);
        gr.PrintRibs();
        System.out.println("\n\n");

        gr.PrintConnectios(1);

    }
}

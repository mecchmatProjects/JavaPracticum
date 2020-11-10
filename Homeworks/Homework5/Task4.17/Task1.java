package Homework5;
//num 4.17


public class Task1 {
    public static void main(String[] args) {

        Tree tree = new Tree("the biggest in the world","seqvoia");
        System.out.println(tree.ToString());
        tree.ToBloom();
        tree.TurnYellow();
        tree.Fall();
        tree.Frost();

        System.out.println("\n\n");

        Branch branch = new Branch("near root");
        System.out.println(branch.ToString());
        branch.ToBloom();
        branch.TurnYellow();
        branch.Fall();
        branch.Frost();
    }
}

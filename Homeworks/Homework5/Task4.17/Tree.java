package Homework5;

class Tree extends Branch {
    private String name;

    Tree(String type, String name) {
        super(type);
        this.name = name;
    }

    @Override
    void ToBloom() {
        System.out.println("Leaves on tree is now blooming");
    }

    @Override
    void TurnYellow() {
        System.out.println("Leaves on tree is turn yellow");
    }

    @Override
    void Fall() {
        System.out.println("Leaves feel out from tree");
    }

    @Override
    void Frost() {
        System.out.println("Leaves on tree are covered by frost");
    }

    @Override
    public String ToString() {
        return "Tree is " + this.name + " with type " + this.type + ".";
    }


}

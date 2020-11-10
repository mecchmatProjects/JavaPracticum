package Homework5;

class Branch extends Leaf {
    protected String type;

    Branch(String type) {
        this.type = type;
    }

    @Override
    void ToBloom() {
        System.out.println("Branch is now blooming");
    }

    @Override
    void TurnYellow() {
        System.out.println("Branch is turn yellow");
    }

    @Override
    void Fall() {
        System.out.println("Leaves feel out from branch");
    }

    @Override
    void Frost() {
        System.out.println("Leaves on branch are covered by frost");
    }

    public String ToString() {
        return "Branch is " + this.type + ".";
    }
}

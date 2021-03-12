package Homework9;

public class Team {
    int name;
    int total_scored;
    int points;
    int total_passed;

    Team(int n){
        name=n;
        total_scored=0;
        points=0;
        total_passed=0;

    }

    int getName(){return name;}
    int getTotal_scored(){return total_scored;}
    int getPoints(){return points;}
    int getTotal_passed(){return total_passed;}

    void addGoals(int scored,int passed){
        total_passed+=passed;
        total_scored+=scored;
    }

    int getDelta(){
        return total_scored-total_passed;
    }

    void addPoints(int point){
        points+=point;
    }
}

package Homework9;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String match_file = "src/Homework9/matches.dat";
        String teams_file = "src/Homework9/teams.dat";
        Tournament obj = new Tournament(teams_file);
        obj.surfMatches(match_file);
        obj.sortbypoints();
        System.out.println(obj);
    }
}

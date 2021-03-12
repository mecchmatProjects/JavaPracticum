package Homework9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tournament {
    ArrayList<Team> teams;

    Tournament(String team_file) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(team_file));

        teams = new ArrayList<>();

        try {
            while (true) {
                String[] infoArr = dis.readLine().split(" ");
                int row = 0;
                for (String sbi : infoArr) {
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i += 2) {
                        a += Character.toString(sbiBytes[i]);
                    }

                    if (a.isEmpty()) continue;
                    row = Integer.parseInt(a);
                }
                if (row!=0)
                    teams.add(new Team(row));

            }

        } catch (EOFException | NullPointerException ignored) {
            dis.close();
        }
    }

    void surfMatches(String match_file) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(match_file));
        int t1, t2, b1,b2;
        try {
            while (true) {
                String[] infoArr = dis.readLine().split(" ");
                ArrayList<Integer> row = new ArrayList<>();
                for (String sbi : infoArr) {
                    byte[] sbiBytes = sbi.trim().getBytes();
                    String a = "";
                    for (int i = 0; i < sbiBytes.length; i += 2) {
                        a += Character.toString(sbiBytes[i]);
                    }

                    if (a.isEmpty()) continue;
                    row.add(Integer.parseInt(a));
                }

                if (!row.isEmpty()){
                    t1 = row.get(0);
                    t2 = row.get(1);
                    b1 = row.get(2);
                    b2 = row.get(3);
                    for(Team x: teams){
                        if (x.getName()==t1){
                            x.addGoals(b1,b2);
                            if(b1>b2){
                                x.addPoints(3);
                            }
                            else if(b2==b1){
                                x.addPoints(1);
                            }
                        }
                        else if (x.getName()==t2){
                            x.addGoals(b2,b1);
                            if(b2>b1){
                                x.addPoints(3);
                            }
                            else if(b2==b1){
                                x.addPoints(1);
                            }
                        }
                    }
                }


            }

        } catch (EOFException | NullPointerException ignored) {
            dis.close();
        }
    }


    void sortbypoints(){
        int n = teams.size();
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (teams.get(i).getPoints() < teams.get(i+1).getPoints()) {
                    Collections.swap(teams, i, i + 1);
                    swapped = true;
                }
                else if (teams.get(i).getPoints() == teams.get(i+1).getPoints()) {
                    if(teams.get(i).getDelta() < teams.get(i+1).getDelta()){
                        Collections.swap(teams, i, i + 1);
                        swapped = true;
                    }
                    else if(teams.get(i).getDelta() == teams.get(i+1).getDelta()){
                        if(teams.get(i).getTotal_scored() < teams.get(i+1).getTotal_scored()){
                            Collections.swap(teams, i, i + 1);
                            swapped = true;
                        }
                        else if(teams.get(i).getTotal_scored() == teams.get(i+1).getTotal_scored()){
                            int a=0;
                            int b=1;
                            if (a + (int) (Math.random() * 1)==1){
                                Collections.swap(teams, i, i + 1);
                                swapped = true;
                            }
                        }
                    }
                }


            }
        }
    }

    @Override
    public String toString() {
        String out = "Place\tName\tPoints\tScored\tPassed\n";
        int i=1;
        for (Team x:teams){
            out += i+"   \t"+x.getName()+"   \t"+x.getPoints()+"   \t"+x.getTotal_scored()+"   \t"+x.getTotal_passed()+"\n";
            i++;
        }
        return out;
    }

}

package team2;

import java.util.Scanner;

//create class Football team
class FootballTeam{
    String name, city;
    int position, wins;
}

public class WithMethod {
    //entering information about the football team
    public static FootballTeam[] setTeamArr(int k){
        Scanner sc = new Scanner(System.in, "cp1251");
        FootballTeam team[]=new FootballTeam[k];
        System.out.println("Enter team information=>");
        for(int i = 0;i< team.length;i++){
            sc.nextLine();
            team[i] = new FootballTeam(); //create new team
            System.out.print("Enter name team number "+(i+1)+" =>");
            team[i].name = sc.nextLine();
            System.out.print("Enter the city of this team=>");
            team[i].city = sc.nextLine();
            System.out.print("Enter this team's league position=>");
            team[i].position = sc.nextInt();
            System.out.print("Enter the number of wins for this team=>");
            team[i].wins = sc.nextInt();
        }
        return team;
    }

    //Output of received information
    public static void showTeams(FootballTeam[]team){
        for(int i = 0;i< team.length;i++){
            System.out.println("Name: "+team[i].name+"\tCity: "+team[i].city+"\tPosition: "+team[i].position+"\tWins:"+team[i].wins);
        }
    }

    //information about one team
    public static void showTeam(FootballTeam team){
        System.out.println("Name: "+team.name+"\tCity: "+team.city+"\tPosition: "+team.position+"\tWins:"+team.wins);
    }

    //Team with the most wins
    public static int MaxWins(FootballTeam[]team) {
        int maxwins = 0;
        int max = team[maxwins].wins;

        for (int i = 0; i < team.length; i++) {
            if (team[i].wins > max) {
                max = team[i].wins;
                maxwins = i;
            }
        }
        return maxwins;
    }

    //search average wins
    public static float averageWins(FootballTeam[]team){
        float aver = 0;
        for(int i = 0;i<team.length; i++){
            aver += team[i].wins;
        }
        float average = aver/team.length;
        return average;
    }

    //Teams with more than average wins
    public static FootballTeam[]More(FootballTeam[]team){
        float average = averageWins(team);
        int amount = 0;

        for(int i = 0;i< team.length; i++){
            if(team[i].wins>average){
                ++amount;
            }
        }
        if(amount!=0){
            FootballTeam[]more = new FootballTeam[amount];
            int n=-1;
            for(int i = 0; i< team.length; i++){
                if(team[i].wins>average){
                    more[++n]=team[i];
                }
            }
            return more;
        }
        else{
            return null;
        }
    }

    //league descending sort
    public static void sortTeams(FootballTeam[]team){
        for(int i = 0;i< team.length-1; i++){
            for(int j = 0; j< team.length-1-i; j++){
                if(team[j].position>team[j+1].position){
                    FootballTeam replacement = team[j];
                    team[j]=team[j+1];
                    team[j+1]=replacement;
                }
            }
        }
    }

    //search teams by name
    public static  FootballTeam findForName(FootballTeam team[], String name){
        int number = -1;
        for(int i = 0;i< team.length; i++){
            if(name.equals(team[i].name)){
                number=i;
            }
        }
        if(number != -1){
            return team[number];
        }
        else{
            return null;
        }
    }

    //main method
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Enter the number of teams=>");
        int amount = sc.nextInt();
        FootballTeam team[]=setTeamArr(amount);

        System.out.println("Team information:");
        showTeams(team);

        int maxwins = MaxWins(team);
        System.out.println("Team with the most wins: ");
        showTeam(team[maxwins]);


        sortTeams(team);
        System.out.println("Sorted teams:");
        showTeams(team);

        System.out.println("Average wins = "+averageWins(team));

        System.out.println(("\nTeams with more than average wins: "));
        FootballTeam[] larger=More(team);
        showTeams(larger);

        System.out.println("Enter team name to search=>");
        sc.nextLine();
        String searchname = sc.nextLine();
        FootballTeam find = findForName(team, searchname);
        if(find != null){
            showTeam(find);
        }
        else{
            System.out.println("This team not found :(");
        }
    }
}

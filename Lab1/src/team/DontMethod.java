package team;

import java.util.Scanner;

//create class Football team
class FootballTeam{
    String name, city;
    int position, wins;
}

public class DontMethod {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "cp1251");

        //entering information about the football team
        System.out.println("Enter the number of teams=>");
        int amount = sc.nextInt(); //number of teams
        FootballTeam team[] = new FootballTeam[amount];
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
        //Output of received information
        System.out.println("\nTeam information:");
        for(int i = 0;i< team.length;i++){
            System.out.println("Name: "+team[i].name+"\tCity: "+team[i].city+"\tPosition: "+team[i].position+"\tWins:"+team[i].wins);
        }

        //Team with the most wins
        int maxwins = 0;
        int max = team[maxwins].wins;

        for(int i = 0; i< team.length; i++){
            if(team[i].wins>max){
                max = team[i].wins;
                maxwins=i;
            }
        }
        System.out.println("\nTeam with the most wins: ");
        System.out.println("Name: "+team[maxwins].name+"\tCity: "+team[maxwins].city+"\tPosition: "+team[maxwins].position+"\tWins:"+team[maxwins].wins);

        //Teams with more than average wins
        int allwins = 0;
        for(int i = 0;i< team.length; i++){
            allwins+=team[i].wins;
        }
        float averagewins = allwins/team.length;
        System.out.println("Average wins: "+ averagewins);
        System.out.println("Teams with more than average wins");
        for(int i = 0;i<team.length; i++){
            if(team[i].wins>averagewins){
                System.out.println("Name: "+team[i].name+"\tCity: "+team[i].city+"\tPosition: "+team[i].position+"\tWins:"+team[i].wins);
            }
        }

        //league descending sort
        for(int i = 0;i< team.length-1; i++){
            for(int j = 0; j< team.length-1-i; j++){
                if(team[j].position>team[j+1].position){
                    FootballTeam replacement = team[j];
                    team[j]=team[j+1];
                    team[j+1]=replacement;
                }
            }
        }
        System.out.println("\nSorted teams:");
        for(int i = 0;i< team.length;i++){
            System.out.println("Name: "+team[i].name+"\tCity: "+team[i].city+"\tPosition: "+team[i].position+"\tWins:"+team[i].wins);
        }


        //search teams by name
        sc.nextLine();
        System.out.println("Enter team name to search=>");
        String name = sc.nextLine();
        int number = -1;

        for(int i = 0;i< team.length; i++){
            if(name.equalsIgnoreCase(team[i].name)){
                number = i;
            }
        }
        if(number!=-1){
            System.out.println("This team is in the list: "+team[number].name+"\tCity: "+team[number].city+"\tPosition: "+team[number].position+"\tWins:"+team[number].wins);
        }
        else{
            System.out.println("This team not found :(");
        }

        //editing
        System.out.println("Enter a new name for the selected team=>");
        String newname = sc.nextLine();
        team[number].name = newname;
        System.out.println("\nEditing team information:");
        for(int i = 0;i< team.length;i++){
            System.out.println("Name: "+team[i].name+"\tCity: "+team[i].city+"\tPosition: "+team[i].position+"\tWins:"+team[i].wins);
        }


    }
}

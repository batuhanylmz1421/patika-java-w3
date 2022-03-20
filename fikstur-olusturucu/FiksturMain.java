import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FiksturMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Getting numver of teams.
        System.out.print("Number of teams: ");
        int teamCount = input.nextInt();
        List<String> teams = new ArrayList<>();

        // Getting team names.
        for (int i=0; i<teamCount ; i++) {
            System.out.print(i+1 + ". team name is: ");
            String team = input.next();
            teams.add(team);
        }

        // If team count is odd than add "Bay" tt the team list.
        if(teamCount%2 == 1) {
            teams.add("Bay");
            teamCount++;
        }


        // Team order random mixer.
        List<String> tempTeams = new ArrayList<>();
        while (teams.size() > 0) {
            int index = (int)(Math.random() * teams.size());
            tempTeams.add(teams.get(index));
            teams.remove(teams.get(index));
        }
        teams = tempTeams;
        int totalRound = teamCount - 1;
        int numberMatchPerRound = teamCount / 2;

        // Creating linked hash map with unique keys.
        LinkedHashMap<String, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();
        for (int i=1; i<=totalRound; i++) {
            String round = String.valueOf(i);
            rounds.put(round, new ArrayList<ArrayList<String>>());
        }
        // Loop for round calculations.
        for (int i=0; i<totalRound ; i++) {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();

            for (int j=0; j<numberMatchPerRound ; j++) {
                // Gets team on front side.
                home.add(teams.get(j));
                // Gets team on back side.
                away.add(teams.get((teamCount - 1) - j));
            }

            // Setting calculated teams to linkedHashMap
            String round = String.valueOf(i + 1);
            rounds.get(round).add(home);
            rounds.get(round).add(away);

            // Calculating new teams.
            List<String> newTeams = new ArrayList<>();
            newTeams.add(teams.get(0));
            newTeams.add(teams.get((teamCount - 1)));
            for (int k=1; k<teams.size() - 1 ; k++) {
                newTeams.add(teams.get(k));
            }
            // Passing new calculated teams to 'teams' to make calculations for other rounds.
            teams = newTeams;
        }
        System.out.println();

        // Printing calculated rounds.
        for (int i=0; i<2*totalRound ; i++) {
            // Printing round number.
            System.out.println("Round " + (i + 1));
            // Printing the table per round.
            for (int j=0; j<numberMatchPerRound ; j++) {
                // If for not to pass total round number.
                if (i < totalRound) {
                    System.out.println(rounds.get(
                            String.valueOf(i + 1)).get(0).get(j) + " vs " +  rounds.get(String.valueOf(i + 1)).get(1).get(j)
                    );
                } else {
                    // Printing last round.
                    System.out.println(rounds.get(
                            String.valueOf(i + 1 - totalRound)).get(1).get(j) + " vs " + rounds.get(String.valueOf(i + 1 - totalRound)).get(0).get(j)
                    );
                }
            }
            System.out.println();  // Newline
        }
    }
}

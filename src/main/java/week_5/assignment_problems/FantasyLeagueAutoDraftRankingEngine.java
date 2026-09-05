import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine implements Comparable<FantasyLeagueAutoDraftRankingEngine> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public FantasyLeagueAutoDraftRankingEngine(String name, int matchesPlayed,
                                               double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    private double getFantasyPoints() {

        return battingAverage;
    }

    @Override
    public int compareTo(FantasyLeagueAutoDraftRankingEngine other) {

        return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
    }

    static String draftAndRank(FantasyLeagueAutoDraftRankingEngine[] players) {

        FantasyLeagueAutoDraftRankingEngine[] draftable =
                new FantasyLeagueAutoDraftRankingEngine[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        FantasyLeagueAutoDraftRankingEngine[] finalDraftable =
                Arrays.copyOf(draftable, count);

        Arrays.sort(finalDraftable);

        String result = "";

        for (int i = 0; i < finalDraftable.length; i++) {

            result = result + (i + 1) + ". " + finalDraftable[i].name;

            if (i < finalDraftable.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        FantasyLeagueAutoDraftRankingEngine[] players = {
            new FantasyLeagueAutoDraftRankingEngine("Virat", 15, 48.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Rahul", 7, 55.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Sameer", 3, 60.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);

        System.out.println(result);
    }
}


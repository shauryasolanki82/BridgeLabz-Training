package bridgelabz.json.IPL;

import java.util.HashMap;
import java.util.Map;

public class CensorService {

    private static String maskTeamName(String teamName) {
        if (teamName == null || !teamName.contains(" ")) {
            return teamName + " ***";
        }
        String[] parts = teamName.split(" ");
        return parts[0] + " ***";
    }

    public static IplMatch censorMatch(IplMatch original) {
        IplMatch censored = new IplMatch();
        censored.setMatchId(original.getMatchId());
        String censoredTeam1 = maskTeamName(original.getTeam1());
        String censoredTeam2 = maskTeamName(original.getTeam2());
        String censoredWinner = maskTeamName(original.getWinner());
        censored.setTeam1(censoredTeam1);
        censored.setTeam2(censoredTeam2);
        censored.setWinner(censoredWinner);
        censored.setPlayerOfMatch("REDACTED");
        Map<String, Integer> newScoreMap = new HashMap<>();
        Map<String, Integer> oldScoreMap = original.getScore();
        
        if (oldScoreMap != null) {
            if (oldScoreMap.containsKey(original.getTeam1())) {
                newScoreMap.put(censoredTeam1, oldScoreMap.get(original.getTeam1()));
            }
            if (oldScoreMap.containsKey(original.getTeam2())) {
                newScoreMap.put(censoredTeam2, oldScoreMap.get(original.getTeam2()));
            }
        }
        censored.setScore(newScoreMap);

        return censored;
    }
}
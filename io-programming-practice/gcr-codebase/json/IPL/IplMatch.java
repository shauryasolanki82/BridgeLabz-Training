package bridgelabz.json.IPL;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Map;

@JsonPropertyOrder({ "match_id", "team1", "team2", "score", "winner", "player_of_match" })
public class IplMatch {
    @JsonProperty("match_id")
    private int matchId;
    
    private String team1;
    private String team2;
    private Map<String, Integer> score;
    private String winner;
    
    @JsonProperty("player_of_match")
    private String playerOfMatch;
    
    public IplMatch() {}

    public IplMatch(int matchId, String team1, String team2, Map<String, Integer> score, String winner, String playerOfMatch) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.score = score;
        this.winner = winner;
        this.playerOfMatch = playerOfMatch;
    }

    public int getMatchId() { 
    	return matchId; 
    }
    public void setMatchId(int matchId) { 
    	this.matchId = matchId; 
    }

    public String getTeam1() { 
    	return team1; 
    }
    public void setTeam1(String team1) { 
    	this.team1 = team1; 
    }

    public String getTeam2() { 
    	return team2; 
    }
    public void setTeam2(String team2) { 
    	this.team2 = team2; 
    }

    public Map<String, Integer> getScore() { 
    	return score; 
    }
    public void setScore(Map<String, Integer> score) { 
    	this.score = score; 
    }

    public String getWinner() { 
    	return winner; 
    }
    public void setWinner(String winner) { 
    	this.winner = winner; 
    }

    public String getPlayerOfMatch() { 
    	return playerOfMatch; 
    }
    public void setPlayerOfMatch(String playerOfMatch) { 
    	this.playerOfMatch = playerOfMatch; 
    }
}
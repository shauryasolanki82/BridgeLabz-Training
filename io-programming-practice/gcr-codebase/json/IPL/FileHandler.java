package bridgelabz.json.IPL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.*;

public class FileHandler {
    private static final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    public static List<IplMatch> readJson(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), new TypeReference<List<IplMatch>>() {});
    }

    public static void writeJson(String filePath, List<IplMatch> matches) throws IOException {
        mapper.writeValue(new File(filePath), matches);
        System.out.println("JSON written to: " + filePath);
    }

    public static List<IplMatch> readCsv(String filePath) throws IOException {
        List<IplMatch> matches = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); 
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int matchId = Integer.parseInt(data[0]);
                String team1 = data[1];
                String team2 = data[2];
                int score1 = Integer.parseInt(data[3]);
                int score2 = Integer.parseInt(data[4]);
                String winner = data[5];
                String player = data[6];
                Map<String, Integer> scoreMap = new HashMap<>();
                scoreMap.put(team1, score1);
                scoreMap.put(team2, score2);
                matches.add(new IplMatch(matchId, team1, team2, scoreMap, winner, player));
            }
        }
        return matches;
    }

    public static void writeCsv(String filePath, List<IplMatch> matches) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("match_id,team1,team2,score_team1,score_team2,winner,player_of_match");
            bw.newLine();

            for (IplMatch m : matches) {
                StringBuilder sb = new StringBuilder();
                sb.append(m.getMatchId()).append(",");
                sb.append(m.getTeam1()).append(",");
                sb.append(m.getTeam2()).append(",");
                Integer s1 = m.getScore().get(m.getTeam1());
                Integer s2 = m.getScore().get(m.getTeam2());
                sb.append(s1 != null ? s1 : 0).append(",");
                sb.append(s2 != null ? s2 : 0).append(",");
                sb.append(m.getWinner()).append(",");
                sb.append(m.getPlayerOfMatch());
                bw.write(sb.toString());
                bw.newLine();
            }
        }
        System.out.println("CSV written to: " + filePath);
    }
}

package iplLeague;

import java.io.IOException;
import java.util.Map;

public class BatsBowlMergeAdapter extends DataLoader{
    public Map<String, IPLLeagueDAO> loadIPLData(String[] csvFilePath) throws IOException, IPLException {
        Map<String, IPLLeagueDAO> iplLeagueBatsMap = super.loadIPLData(Batsmans.class,csvFilePath[0]);
        Map<String, IPLLeagueDAO> iplLeagueBowlMap = super.loadIPLData(Bowlers.class, csvFilePath[1]);
        iplLeagueBowlMap.values().stream()
                .filter(iplRun -> iplLeagueBatsMap.get(iplRun.player)!= null)
                .forEach(iplRun -> iplLeagueBatsMap.get(iplRun.player).bowl_avg=iplRun.bowl_avg);

        return iplLeagueBatsMap;

    }
}

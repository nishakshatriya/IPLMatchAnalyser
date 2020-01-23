package iplLeague;

import java.io.IOException;
import java.util.Map;

public class CricketFactory {

    public static <E> Map<String,IPLLeagueDAO> loadingData(IPLleagueAnalysis.Cricket cricket, String... csvFilePath) throws IPLException, IOException, IOException {
        if (cricket.equals(IPLleagueAnalysis.Cricket.BATSMANS)) {
            return new BattingAdapter().getData(Batsmans.class,csvFilePath);
        } else if (cricket.equals(IPLleagueAnalysis.Cricket.BOWLERS)) {
            return new BowlersAdapter().getData(Bowlers.class,csvFilePath);
        } else if (cricket.equals(IPLleagueAnalysis.Cricket.BatsmanBowlersCombo)){
            return new BatsBowlMergeAdapter().loadIPLData(csvFilePath);
        } else {
            throw new IPLException("INCORRECT_DATA", IPLException.ExceptionType.NO_DATA_AVAIL);
        }
    }
}

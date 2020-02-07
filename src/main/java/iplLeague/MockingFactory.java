package iplLeague;

import java.io.IOException;
import java.util.Map;

public class MockingFactory {

    public Map<String,IPLLeagueDAO> getData(IPLleagueAnalysis.Cricket cricket, String... csvFilePath) throws IOException, IPLException {
        return new CricketFactory().loadingData(cricket,csvFilePath);
    }
}















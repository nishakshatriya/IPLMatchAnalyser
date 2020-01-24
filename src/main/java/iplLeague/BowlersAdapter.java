package iplLeague;

import java.io.IOException;
import java.util.Map;

public class BowlersAdapter extends DataLoader{
//    public Map<String,IPLLeagueDAO> getData(String... csvFilePath) throws IPLException, IOException {
//        Map<String,IPLLeagueDAO> censusDAOMap = super.loadIPLData(Bowlers.class, csvFilePath[0]);
//        return censusDAOMap;
//    }

    @Override
    public <E> Map<String, IPLLeagueDAO> loadIPLData(String... csvFilePath) throws IPLException, IOException {
        Map<String,IPLLeagueDAO> censusDAOMap = super.loadIPLData(Bowlers.class, csvFilePath[0]);
        return censusDAOMap;
    }
}

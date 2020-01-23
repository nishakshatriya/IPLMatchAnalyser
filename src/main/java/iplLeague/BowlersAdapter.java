package iplLeague;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BowlersAdapter extends DataLoader {
    @Override
    public Map<String,IPLLeagueDAO> loadIPLData(String... csvFilePath) throws IPLException, IOException {
        Map<String,IPLLeagueDAO> censusDAOMap = super.loadIPLData(Bowlers.class, csvFilePath[0]);
        return censusDAOMap;
    }
}

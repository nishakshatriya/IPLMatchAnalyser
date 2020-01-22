package iplLeague;

import java.io.IOException;
import java.util.List;

public class BowlersAdapter extends DataLoader {
    @Override
    public <E> List<IPLLeagueDAO> loadIPLData(String... csvFilePath) throws IPLException, IOException {
        List<IPLLeagueDAO> censusDAOMap = super.loadIPLData(Bowlers.class, csvFilePath[0]);
        return censusDAOMap;
    }
}

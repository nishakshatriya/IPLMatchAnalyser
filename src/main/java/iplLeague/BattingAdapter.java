package iplLeague;

import java.io.IOException;
import java.util.Map;

public class BattingAdapter extends DataLoader{
    public <E> Map<String,IPLLeagueDAO> getData(Class<Batsmans> batsmansClass, String... csvFilePath) throws IPLException, IOException {
        Map<String,IPLLeagueDAO> censusDAOMap = super.loadIPLData(Batsmans.class, csvFilePath[0]);
        return censusDAOMap;
    }
}
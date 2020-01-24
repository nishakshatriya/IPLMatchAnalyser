package iplLeague;

import java.io.IOException;
import java.util.Map;


public class BattingAdapter extends DataLoader{


    @Override
    public <E> Map<String, IPLLeagueDAO> loadIPLData(String... csvFilePath) throws IPLException, IOException {

        Map<String,IPLLeagueDAO> censusDAOMap = super.loadIPLData(Batsmans.class, csvFilePath[0]);
        return censusDAOMap;
    }
}
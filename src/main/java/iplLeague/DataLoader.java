package iplLeague;


import CSVBuilder.CSVBuilderException;
import CSVBuilder.CSVBuilderFactory;
import CSVBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.StreamSupport;

public abstract class DataLoader {
    public abstract  <E> Map<String, IPLLeagueDAO> loadIPLData(String...csvFilePath) throws IPLException, IOException;

    public <E> Map<String, IPLLeagueDAO> loadIPLData(Class<E> CSVClass, String... csvFilePath) throws IPLException, IOException {
        Map<String, IPLLeagueDAO> list = new TreeMap<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(String.valueOf(csvFilePath[0])))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> playersList = icsvBuilder.getCSVFileList(reader, CSVClass);
            if (CSVClass.getName().equals("iplLeague.Batsmans")) {
                StreamSupport.stream(playersList.spliterator(), false)
                        .map(Batsmans.class::cast)
                        .forEach(cricketCSV -> list.put(cricketCSV.player, new IPLLeagueDAO((cricketCSV))));
            } else if (CSVClass.getName().equals("iplLeague.Bowlers")) {
                StreamSupport.stream(playersList.spliterator(), false)
                        .map(Bowlers.class::cast)
                        .forEach(cricketCSV -> list.put(cricketCSV.player, new IPLLeagueDAO(cricketCSV)));
            }
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.NO_DATA_AVAIL);
        } catch (RuntimeException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.FILE_ERROR);
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return list;
    }
}




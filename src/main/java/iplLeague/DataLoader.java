package iplLeague;

import csvFileBuilder.CSVBuilderException;
import csvFileBuilder.CSVBuilderFactory;
import csvFileBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.StreamSupport;

public abstract class DataLoader  {

    public <E> Map loadIPLData(Class<E> CSVClass, String csvFilePath) throws IPLException, IOException {
        Map<String,IPLLeagueDAO> list = new TreeMap<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List<E> playersList = icsvBuilder.getCSVInList(reader, CSVClass);
            if (CSVClass.getName().equals("iplLeague.Batsmans")) {
                StreamSupport.stream(playersList.spliterator(), false)
                        .map(Batsmans.class::cast)
                        .forEach(cricketCSV -> list.put(cricketCSV.player, new  IPLLeagueDAO((cricketCSV))));
            } else {
                StreamSupport.stream(playersList.spliterator(), false)
                        .map(Bowlers.class::cast)
                        .forEach(cricketCSV -> list.put(cricketCSV.player ,new IPLLeagueDAO(cricketCSV)));
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

    public abstract  <E> Map< String,IPLLeagueDAO> loadIPLData(String... csvFilePath) throws IPLException, IOException;
    }




package iplLeague;

import csvFileBuilder.CSVBuilderException;
import csvFileBuilder.CSVBuilderFactory;
import csvFileBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class DataLoader {

    public static  <E> List loadIPLData(String csvFilePath, Class<E> CSVClass  ) throws IPLException, IOException {
        List<IPLLeagueDAO> list = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List<E> playersList = icsvBuilder.getCSVInList(reader, CSVClass);
            if(CSVClass.getName().equals("iplLeague.Batsmans")) {
                StreamSupport.stream(playersList.spliterator(), false)
                    .map(Batsmans.class::cast)
                    .forEach(cricketCSV -> list.add(new IPLLeagueDAO((Batsmans) cricketCSV)));
            }
            else {
                StreamSupport.stream(playersList.spliterator(), false)
                    .map(Bowlers.class::cast)
                    .forEach(cricketCSV -> list.add(new IPLLeagueDAO((Bowlers) cricketCSV)));
            }
        } catch (IOException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType. NO_DATA_AVAIL);
        } catch (RuntimeException e) {
            throw new IPLException(e.getMessage(), IPLException.ExceptionType.FILE_ERROR);
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return list;
    }
}


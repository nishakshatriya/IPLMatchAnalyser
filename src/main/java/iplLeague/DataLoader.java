package iplLeague;

import csvFileBuilder.CSVBuilderException;
import csvFileBuilder.CSVBuilderFactory;
import csvFileBuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DataLoader {

    public static List<IPLLeagueDAO> loadIplRunCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        List<IPLLeagueDAO> list = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, Batsmans.class);
            StreamSupport.stream(playersList.spliterator(), false)
                    .map(Batsmans.class::cast)
                    .forEach(cricketCSV -> list.add(new IPLLeagueDAO((Batsmans) cricketCSV)));
            return list;
        }catch (NoSuchFileException e){
            throw new IPLException(e.getMessage(),
                    IPLException.ExceptionType.FILE_ERROR);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return null;
    }

    public static List<IPLLeagueDAO> loadIplBowlCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        List<IPLLeagueDAO> bowlersList = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, Bowlers.class);
            StreamSupport.stream(playersList.spliterator(), false)
                    .map(Bowlers.class::cast)
                    .forEach(cricketCSV -> bowlersList.add(new IPLLeagueDAO((Bowlers) cricketCSV)));
            return bowlersList;
        }catch (NoSuchFileException e){
            throw new IPLException(e.getMessage(),
                    IPLException.ExceptionType.FILE_ERROR);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (CSVBuilderException e) {
            throw new IPLException(e.getMessage(), e.type.name());
        }
        return null;
    }
}


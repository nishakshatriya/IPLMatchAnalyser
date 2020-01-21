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

public class DataLoader {

    public static List<Batsmans> loadIplRunCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        List<Batsmans> list = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, Batsmans.class);
            playersList.stream().filter(CensusData -> list.add((Batsmans) CensusData)).collect(Collectors.toList());
            return playersList;
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

    public static List<Bowlers> loadIplBowlCensusData(String csvFilePath) throws IPLException, IOException, CSVBuilderException {
        List<Bowlers> bowlersList = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.CreateCSVBuilder();
            List playersList = icsvBuilder.getCSVInList(reader, Bowlers.class);
            playersList.stream().filter(CensusData -> bowlersList.add((Bowlers) CensusData)).collect(Collectors.toList());
            return playersList;
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


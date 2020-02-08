package iplLeague;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class BattingMockitoTestCases {

    private String MOSTRUNSFILE = "/home/admin1/Desktop/IPLMatchAnalyser/src/test/resources/IPLMOSTRUNDATACSV.csv";

    Map<String, IPLLeagueDAO> cricketMap = new HashMap<>();

    @Before
    public void givenPlayersData() {
        Batsmans batsmans = new Batsmans("David Warner", 692, 69.2, 86, 57, 21);
        Batsmans batsmans1 = new Batsmans("Virat Kohli", 464, 33.14, 141.46, 46, 13);
        cricketMap.put("batting", new IPLLeagueDAO(batsmans));
        cricketMap.put("batting", new IPLLeagueDAO(batsmans1));
    }

    @Mock
    MockingFactory mockingFactory;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void WhenGivenDataList_ShouldReturnDataInMockito() throws IOException {
        try {
            IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BATSMANS, mockingFactory);
            when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BATSMANS, MOSTRUNSFILE)).thenReturn(cricketMap);
            int totalRecords = ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
            System.out.printf("total record: " + totalRecords);
            Assert.assertEquals(1, totalRecords);
        } catch (IPLException e) {

        }
    }

    @Test
    public void WhenGivenBattingData_ShouldReturnMockitoObject() throws IOException, IPLException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BATSMANS, mockingFactory);
        when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BATSMANS, MOSTRUNSFILE)).thenReturn(cricketMap);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> batsmanList = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.AVG_BATTING);
        Assert.assertEquals(464.0, batsmanList.get(0).runs, 0.0);
    }

    @Test
    public void WhenGivenBattingData1_ShouldReturnMockitoObject() throws IOException, IPLException {
        IPLleagueAnalysis ipLleagueAnalysis = new IPLleagueAnalysis(IPLleagueAnalysis.Cricket.BATSMANS, mockingFactory);
        when(mockingFactory.getData(IPLleagueAnalysis.Cricket.BATSMANS, MOSTRUNSFILE)).thenReturn(cricketMap);
        ipLleagueAnalysis.loadingData(MOSTRUNSFILE);
        List<Batsmans> batsmanList = ipLleagueAnalysis.getSortedFields(Sorting.sortingFields.AVG_BATTING);
        Assert.assertEquals(13, batsmanList.get(0).sixer, 0.0);
    }
}



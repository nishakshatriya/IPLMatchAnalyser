package iplLeague;

public class IPLLeagueDAO {
    public double strikeRate;
    public int fours;
    public int four_wkts;
    public int sixer;
    public int five_wkts;
    public int runs;
    public double avg;
    public String player;

    public IPLLeagueDAO(Batsmans batsmans) {
        strikeRate = batsmans.strikeRate;
        fours = batsmans.fours;
        sixer = batsmans.sixer;
        runs = batsmans.runs;
        avg = batsmans.avg;
        player = batsmans.player;
    }

    public IPLLeagueDAO(Bowlers bowlers)
    {
        avg = bowlers.avg;
        runs = bowlers.runs;
        strikeRate = bowlers.strikeRate;
        four_wkts = bowlers.four_wkts;
        five_wkts = bowlers.five_wkts;
        player = bowlers.player;

    }



}

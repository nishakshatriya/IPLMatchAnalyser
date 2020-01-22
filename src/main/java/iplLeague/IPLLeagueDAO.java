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
    public double Economy;
    public double bowlStrikeRate;

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
        bowlStrikeRate = bowlers.sr;
        four_wkts = bowlers.four_wkts;
        five_wkts = bowlers.five_wkts;
        player = bowlers.player;
        Economy = bowlers.Economy;

    }

    @Override
    public String toString() {
        return "IPLLeagueDAO{" +
                "strikeRate=" + strikeRate +
                ", fours=" + fours +
                ", four_wkts=" + four_wkts +
                ", sixer=" + sixer +
                ", five_wkts=" + five_wkts +
                ", runs=" + runs +
                ", avg=" + avg +
                ", player='" + player + '\'' +
                ", Economy=" + Economy +
                ", bowlStrikeRate=" + bowlStrikeRate +
                '}';
    }
}

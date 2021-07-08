package proxy.exercise.statical;

public class ProxyStation implements IStation
{
    private final Station station;

    public ProxyStation(Station station) {
        this.station = station;
    }

    @Override
    public void sellTicket()
    {
        station.sellTicket();
    }
}

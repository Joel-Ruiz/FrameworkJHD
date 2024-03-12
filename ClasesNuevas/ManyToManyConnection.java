package CH.ifa.draw.figures;

public class ManyToManyConnection extends LineConnection{
    public ManyToManyConnection(){
        setStartDecoration(new ManyToManyTip());
        setEndDecoration(new ManyToManyTip());
    }
}

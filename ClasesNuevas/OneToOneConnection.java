package CH.ifa.draw.figures;

public class OneToOneConnection extends LineConnection{
    
    public OneToOneConnection(){
        setStartDecoration(new OneToOneTip());
        setEndDecoration(new OneToOneTip());
    }
}

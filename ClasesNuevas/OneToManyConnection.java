package CH.ifa.draw.figures;

public class OneToManyConnection extends LineConnection{
    
    public OneToManyConnection(){
        setStartDecoration(new ManyToManyTip());
        setEndDecoration(new OneToOneTip());
    }
}

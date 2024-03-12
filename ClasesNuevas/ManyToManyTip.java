package CH.ifa.draw.figures;

import java.awt.*;
import java.io.IOException;

import javax.swing.text.Position;

import CH.ifa.draw.util.StorableInput;
import CH.ifa.draw.util.StorableOutput;

public class ManyToManyTip extends AbstractLineDecoration{

    private double fAngle;
    private double fOuterRadius;
    private double fInnerRadius;

    public ManyToManyTip(){
        this(0.40, 15, 4);
    }

    public ManyToManyTip(double angle, double outerRadius, double innerRadius){
        setAngle(angle);
        setOuterRadius(outerRadius);
        setInnerRadius(innerRadius);
    }

    protected void setAngle(double newAngle){
        fAngle = newAngle;
    }

    protected double getAngle(){
        return fAngle;
    }

    protected void setInnerRadius(double newInnerRadius){
        fInnerRadius = newInnerRadius;
    }

    protected double getInnerRadius(){
        return fInnerRadius;
    }

    protected void setOuterRadius(double newOterRadius){
        fOuterRadius = newOterRadius;
    }

    protected double getOuterRadius(){
        return fOuterRadius;
    }

    @Override
    public Polygon outline(int x1, int y1, int x2, int y2){
        double dir = Math.PI/2 - Math.atan2(x2 - x1, y2 - y1);
        return outline(x2, y2, dir);
    }

    private Polygon outline(int x, int y, double direction){
        Polygon shape = new Polygon();
        shape.addPoint(x, y);
        addPointRelative(shape, x, y, getOuterRadius(), direction - getAngle());
        addPointRelative(shape, x, y, getInnerRadius(), direction);
        addPointRelative(shape, x, y, getOuterRadius(), direction + getAngle());
        shape.addPoint(x, y);
        return shape;
    }

    private void addPointRelative(Polygon shape, int x, int y, double radius, double angle){
        shape.addPoint(
            x + (int)(radius * Math.cos(angle)),
            y + (int)(radius * Math.sin(angle))
        );
    }

    public void write (StorableOutput dw){
        dw.writeDouble(getAngle());
        dw.writeDouble(getInnerRadius());
        dw.writeDouble(getOuterRadius());
        super.write(dw);
    }

    public void read(StorableInput dr) throws IOException{
        setAngle(dr.readDouble());
        setInnerRadius(dr.readDouble());
        setOuterRadius(dr.readDouble());
        super.read(dr);
    }
}
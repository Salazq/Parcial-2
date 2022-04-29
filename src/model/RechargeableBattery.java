package model;

public class RechargeableBattery extends Battery implements Rechargable {

    private int chargerNumber;
    private char type;
    private double factor;
    public final static char BATTERY_LITIO= 'l';
    public final static char BATTERY_NIQUEL_CADIO= 'n';
    public final static double FACTOR_LITIO= 0.92;
    public final static double FACTOR_NIQUEL_CADIO= 0.8;




    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type){

        super(name, voltage, cost, capacity);
        this.chargerNumber=chargerNumber;
        this.type= type;

        if (type=='l'){
            factor= FACTOR_LITIO;
        }
        else {
            factor= FACTOR_NIQUEL_CADIO;
        }
        
    }

    @Override
    public double calculateUsefulLifeCost(){

        double lifeCost;

        lifeCost=cost*voltage*capacity/(1000*chargerNumber*factor);

        return lifeCost;
    }
    
    @Override
    public String toString(){

        return "\nBateria recargable \nNombre: " +name+ "\nCosto de vida útil: "+ calculateUsefulLifeCost() ;

    }


}

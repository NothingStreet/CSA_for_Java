package Work2.H2;

public abstract class Vehicle {
    protected int wheels;
    protected double weight;

    public Vehicle(int wheels,double weight){
        this.wheels=wheels;
        this.weight=weight;
    }

    public double getWeight() {return weight;}
    public void setWeight(double weight) {this.weight = weight;}

    public int getWheels() {return wheels;}
    public void setWheels(int wheels){this.wheels=wheels;}

    public void printInfo(){System.out.println("车轮的个数是："+wheels+" 车重："+weight);}

    public abstract void Judge();
}

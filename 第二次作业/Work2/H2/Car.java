package Work2.H2;

public class Car extends Vehicle{
    private int loader;
    public Car(int wheels,double weight,int loader){
        super(wheels,weight);
        this.loader=loader;
    }

    public int getLoader() {
        return loader;
    }
    public void setLoader(int loader){this.loader=loader;}

    @Override
    public void Judge(){
        if(loader<=5&loader>=0){
            System.out.println("这是一辆小车，能载"+5+"人"+"，实载"+loader+"人");
        }
        else{
            System.out.println("这是一辆小车，能载"+5+"人"+"，实载"+loader+"人，你超员了！");
        }
    }
}

package Work2.H2;

public class Truck extends Vehicle{
    private int loader;
    private double payload;

    public Truck(int wheels,double weight,int loader,double payload){
        super(wheels,weight);
        this.loader=loader;
        this.payload=payload;
    }

    public int getLoader() {return loader;}
    public void setLoader(int loader) {this.loader = loader;}
    public double getPayload() {return payload;}
    public void setPayload(double payload) {
        this.payload = payload;
    }

    @Override
    public void Judge(){
        if(loader<=3&&loader>=0){
            System.out.println("这是一辆卡车，能载"+3+"人"+"，实载"+loader+"人");
        }
        else{
            System.out.println("这是一辆卡车，能载"+3+"人"+"，实载"+loader+"人"+"你超员了！");
        }

        if(payload<=5000&&payload>=0){
            System.out.println("这是一辆卡车，核载"+5000+"kg,"+"你已装载"+payload+"kg");
        }
        else{
            System.out.println("这是一辆卡车，核载"+5000+"kg,"+"你已装载"+payload+"kg,你超载了！");
        }
    }
}

package javaTester;

public class Topic_14_getter_Setter {

    private  String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarMachine() {
        return carMachine;
    }

    public void setCarMachine(String carMachine) {
        this.carMachine = carMachine;
    }

    private  String carType;
    private  String carColor;
    private  String carMachine;
    // private: ben ngoai k the truy cap truc tiep dc, chi co the thong qua ham
    

    public static void main(String[] args) {

        Topic_14_getter_Setter topic_14 = new Topic_14_getter_Setter();


    }


}

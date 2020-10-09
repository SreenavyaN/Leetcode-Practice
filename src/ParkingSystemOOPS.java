public class ParkingSystemOOPS {
    public static void main(String args[]){
        int big = 2;
        int medium = 2;
        int small = 1;
        int carType = 2;
        ParkingSystem obj = new ParkingSystem(big, medium, small);
        boolean param_1 = obj.addCar(carType);
        System.out.println("Result is :"+param_1);
    }
}
class ParkingSystem {
    int big;
    int medium;
    int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1 && big >= 1){
            big--;
            return true;
        }
        else if(carType == 2 && medium >= 1){
            medium--;
            return true;
        }
        else if(carType == 3 && small >= 1){
            small--;
            return true;
        }
        return false;
    }
}

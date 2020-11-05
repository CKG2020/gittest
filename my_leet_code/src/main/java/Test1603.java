public class Test1603 {
    private int big;
    private int medium;
    private int small;

    public Test1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big > 0) {
                    big--;
                    return true;
                }
                System.out.println("已无车位");
               break;

            case 2:
                if (medium > 0) {
                    medium--;
                    return true;
                }
                System.out.println("已无车位");

                break;

            case 3:

                if (small > 0) {
                    small--;
                    return true;
                }
                System.out.println("已无车位");

                break;
            default:
                System.out.println("没有该车型大小的车位");
        }

        return  false;
    }

    public static void main(String[] args) {
        Test1603 test1603 = new Test1603(1, 1, 1);
        System.out.println(test1603.addCar(1));
        System.out.println(test1603.addCar(1));
        System.out.println(test1603.addCar(2));
        System.out.println(test1603.addCar(4));


    }
}

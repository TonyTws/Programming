package Extra.TCS;

import java.util.*;

public class ShirtDiscount {
    public static void main(String args[]) throws Exception {
        /* Do not alter code in main method */
        Shirt[] shirts = new Shirt[5];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            int tag = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            char g = sc.nextLine().charAt(0);
            shirts[i] = new Shirt(tag, brand, price, g);
        }


        double price = sc.nextDouble();

        for (Shirt s : shirts) {
            System.out.println(getDiscountPrice(s));
        }

        Shirt[] result = getShirtWithMoreThanSpecificPrice(shirts, price);

        for (Shirt s : result) {
            System.out.println(s.getTag() + " " + s.getPrice() + " " + s.getBrand());
        }
    }

    private static Shirt[] getShirtWithMoreThanSpecificPrice(Shirt[] shirts, double price) {
        List<Shirt> list = new ArrayList<>();

        for(Shirt s : shirts){
            if(s.getPrice() > price){
                list.add(s);
            }
        }
        Collections.sort(list,new Comparator<Shirt>() {
            @Override
            public int compare(Shirt o1, Shirt o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });

        Shirt[] sh = new Shirt[list.size()];
        for (int i = 0; i < sh.length ; i++) {
            sh[i] = list.get(i);
        }
        return sh;
    }

    private static double getDiscountPrice(Shirt s) {
        double amount = s.getPrice();
        double discount = 0;
        char gender = s.getGender();
        if (gender == 'm') {
            discount = amount * 0.1;
        } else if (gender == 'f') {
            discount = amount * 0.2;
        } else {
            discount = amount * 0.3;
        }
        return amount - discount;
    }

    /* implement your methods here*/
}

class Shirt {
    //define the class as per details shared in the question
    int tag;
    String brand;
    double price;
    char gender;

    public Shirt(int tag, String brand, double price, char gender) {
        this.tag = tag;
        this.brand = brand;
        this.price = price;
        this.gender = gender;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}

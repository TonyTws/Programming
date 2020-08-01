package Extra.TCS;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        //code to read values
        //code to call required method
        //code to display the result
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] t = new TravelAgencies[4];
        for (int i = 0; i < 4; i++) {
            int regNo = sc.nextInt();
            sc.nextLine();
            String agencyName = sc.nextLine();
            String pakageType = sc.nextLine();
            int price =sc.nextInt();
            boolean flightFacility = sc.nextBoolean();
            t[i] = new TravelAgencies(regNo,agencyName,pakageType,price,flightFacility);
        }
        int r = sc.nextInt();
        sc.nextLine();
        String p = sc.nextLine();
//        for (int i = 0; i < 4; i++) {
//            System.out.println(t[i].getRegNo());
//            System.out.println(t[i].getAgencyName());
//            System.out.println(t[i].getPakageType());
//            System.out.println(t[i].getPrice());
//            System.out.println(t[i].isFlightFacility());
//        }
//        System.out.println(r);
//        System.out.println(p);
        System.out.println(findAgencyWithHighestPackagePrice(t));
        TravelAgencies t1 = agencyDetailsForGivenIdAndType(t,r,p);
        if(t1 != null) {
            System.out.println(t1.getAgencyName() + ":" + t1.getPrice());
        }else{
            System.out.println(t1.toString());
            System.exit(0);
        }
    }


    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies)
    {
        //method logic
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <4 ; i++) {
             max = Math.max(max,agencies[i].getPrice());
        }
        return max;
    }

    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] agencies, int

            regNo, String packageType)
    {

        return null;

    }
}
class TravelAgencies
{
    //code to build the class
    int regNo;
    String agencyName;
    String pakageType;
    int price;
    boolean flightFacility;

    public TravelAgencies(int regNo, String agencyName, String pakageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.pakageType = pakageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPakageType() {
        return pakageType;
    }

    public void setPakageType(String pakageType) {
        this.pakageType = pakageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}
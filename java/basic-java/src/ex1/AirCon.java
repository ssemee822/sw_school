package ex1;

import java.util.Calendar;

public class AirCon {
    boolean isPower;
    int CurTemp;
    int SetTemp;
    int WindSpeed;

    final int[] monthTemp = {-5, 3, 10, 15, 22, 28, 32, 30, 24, 16, 8, 4};
    int month = Calendar.getInstance().get(Calendar.MONTH);
    int avgTemp = monthTemp[month];

    public AirCon(boolean isPower, int CurTemp, int WindSpeed) {
        this.isPower = isPower;
        this.CurTemp = CurTemp;
        this.SetTemp = avgTemp;
        this.WindSpeed = WindSpeed;
    }

    public AirCon() {
        this.isPower = true;
        this.CurTemp = avgTemp;
        this.SetTemp = 20;
        this.WindSpeed = 1;
    }

    public void getInfo() {
        System.out.println("Is Power: " + this.isPower);
        System.out.println("Current Temp: " + this.CurTemp);
        System.out.println("Set Temp: " + this.SetTemp);
        System.out.println("Wind Speed: " + this.WindSpeed);
    }

    public boolean isPower() {
        return isPower;
    }

    public void setPower(boolean power) {
        if (power){
            this.isPower = true;
            this.CurTemp = avgTemp;
            this.SetTemp = 20;
            this.WindSpeed = 2;
        }
        else {
            this.isPower = false;
            this.CurTemp = 0;
            this.SetTemp = 0;
            this.WindSpeed = 0;
        }
    }

    public int getCurTemp() {
        return CurTemp;
    }

    public void setCurTemp(int curTemp) {
        CurTemp = curTemp;
    }

    public int getSetTemp() {
        return SetTemp;
    }

    public void setSetTemp(int setTemp) {
        SetTemp = setTemp;
    }

    public int getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        if (windSpeed <= 3 && windSpeed >= 1) {
            WindSpeed = windSpeed;
        }
        else {
            System.out.println("Invalid wind speed");
        }
    }
}

 class SmartAirCon extends AirCon{
    boolean isAuto;

    public SmartAirCon(boolean isPower, int CurTemp, int WindSpeed, boolean isAuto) {
        this.isAuto = isAuto;
    }
     public SmartAirCon() {
         this.isAuto = false;
     }

     @Override
     public void getInfo() {
         System.out.println("Is Power: " + this.isPower);
         System.out.println("Current Temp: " + this.CurTemp);
         System.out.println("Set Temp: " + this.SetTemp);
         System.out.println("Wind Speed: " + this.WindSpeed);
         System.out.println("isAuto: " + this.isAuto);
     }

     public boolean isAuto() {
         return isAuto;
     }

     public void setAuto(boolean auto) {
        if (auto){
         this.SetTemp = 20;
         this.WindSpeed = 2;
        }
         this.isAuto = auto;
     }
 }

class PortableAirCon extends AirCon{
    int battery;

    public PortableAirCon(boolean isPower, int CurTemp, int WindSpeed, int battery) {
        this.battery = battery;
    }
    public PortableAirCon() {
        this.battery = 100;
    }

    @Override
    public void getInfo() {
        System.out.println("Is Power: " + this.isPower);
        System.out.println("Current Temp: " + this.CurTemp);
        System.out.println("Set Temp: " + this.SetTemp);
        System.out.println("Wind Speed: " + this.WindSpeed);
        System.out.println("battery: " + this.battery);
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
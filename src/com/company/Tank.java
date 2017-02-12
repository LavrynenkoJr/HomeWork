package com.company;

/**
 * Created by Cyborg on 2/12/2017.
 */

@FirstAnnotation
public class Tank {

    private String model;

    @InitAnnotation
    public void drive(){
        System.out.println("drive method");
        System.out.println("brrrr");
    }

    @InitAnnotation
    public void shoot(){
        System.out.println("shoot method");
        System.out.println("PeW!!");
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Tank{" +
                "model='" + model + '\'' +
                '}';
    }
}

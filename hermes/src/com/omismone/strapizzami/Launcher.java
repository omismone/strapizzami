package com.omismone.strapizzami;

import com.omismone.strapizzami.services.PersistenceFacade;

public class Launcher {
    public static void main(String[] args){
        PersistenceFacade.getInstance().getDishes().forEach(x -> {System.out.println(x.getName());});
    }
}

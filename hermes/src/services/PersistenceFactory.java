package services;

import services.dao.*;
import services.dao.rdb.dao.*;

/**
 * this class is the manager of dao's instantiation
 * here is where the program decide what implementation of dao is chosen
 */
public class PersistenceFactory {
    private static PersistenceFactory singleton;

    private IFormatDao format_dao;
    private IClasseDao classe_dao;
    private IIngredientDao ingredient_dao;
    private IDrinkDao drink_dao;
    private IDishDao dish_dao;
    private IPizzaDao pizza_dao;

    private PersistenceFactory(){
        format_dao = new RDBFormatDao();
        classe_dao = new RDBClasseDao();
        ingredient_dao = new RDBIngredientDao();
        drink_dao = new RDBDrinkDao();
        dish_dao = new RDBDishDao();
        pizza_dao = new RDBPizzaDao();
    }
    public static PersistenceFactory getInstance(){
        if(singleton == null) singleton = new PersistenceFactory();
        return singleton;
    }

    public IFormatDao getFormatDao(){
        return format_dao;
    }

    public IClasseDao getClasseDao(){
        return classe_dao;
    }

    public IIngredientDao getIngredientDao(){
        return ingredient_dao;
    }

    public IDrinkDao getDrinkDao(){
        return drink_dao;
    }

    public IDishDao getDishDao(){
        return dish_dao;
    }

    public IPizzaDao getPizzaDao(){
        return pizza_dao;
    }
}

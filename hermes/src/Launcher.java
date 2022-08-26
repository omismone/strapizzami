import services.PersistenceFacade;

public class Launcher {
    public static void main(String[] args){
        PersistenceFacade.getInstance().getIngredients().forEach(x -> {System.out.println(x.getName());});
    }
}

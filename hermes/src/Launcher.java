import services.PersistenceFacade;

public class Launcher {
    public static void main(String[] args){
        PersistenceFacade.getInstance().getPizzas().forEach(x -> {System.out.println(x.getName() + "  " + x.getFormat().getName());});
    }
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Invoker {
    
    private static Map<String, Class> comandos = new HashMap<String, Class>();
    
    private static List<Command> history = new ArrayList<Command>();
    
    static{
        comandos.put("A", ACommand.class);
        comandos.put("B", BCommand.class); 
    }
    
    public static void invoke(String command){
        try {
            Command c = (Command)comandos .get(command).newInstance();
            c.execute();
            history.add(c);
        } catch (InstantiationException ex) {
            Logger.getLogger(Invoker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Invoker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void reExecuteAll(){
        for(Command command: history){
            command.execute();
        }
    }
}

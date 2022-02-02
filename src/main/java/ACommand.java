
public class ACommand implements Command {
    
    private static int count = 0;
    private int n;
    
    public ACommand(){
        count++;
        n = count;
    }

    @Override
    public void execute() { 
        System.out.println("Executou o comando A na instância n = " + n);
    }
    
}

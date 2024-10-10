package Third_practice.Zadanie2;

public class Window {

    private Main.Window_type _type;

    public Window(Main.Window_type _type) {
        this._type = _type;
    }
    public static int False_count = 0;
    public static int True_count = 0;

    public static void False_count_add(){
        False_count++;
    }
    public static void True_count_add(){
        True_count++;
    }

    public synchronized boolean Visit(Citizen visitor){

        if(_type == Main.Window_type.universal){
            return true;
        }
        if(_type == Main.Window_type.pozilie){
            if(visitor.GetType() == Main.Visitor_type.pozilie) return true;
        }
        if(_type == Main.Window_type.business){
            if(visitor.GetType() == Main.Visitor_type.business) return true;
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}

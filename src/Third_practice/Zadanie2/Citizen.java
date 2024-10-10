package Third_practice.Zadanie2;

import java.util.Random;

public class Citizen implements Runnable {

    private Main.Visitor_type _type;

    public Citizen(Main.Visitor_type _type) {
        this._type = _type;
    }
    public Main.Visitor_type GetType(){
        return _type;
    }

    @Override
    public void run() {
        Window win = Main.GetWindows();

        if(win.Visit(this)){
            win.True_count_add();
        }
        else{
            win.False_count_add();
        }

    }
}

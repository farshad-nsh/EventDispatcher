import java.util.ArrayList;
import java.util.List;

public class App {

    public static class SmallTask implements Events {
        public List<Handler> listOfHandlers;
        public SmallTask() {
            super();
            listOfHandlers=new ArrayList<Handler>();
        }
        @Override
        public List<Handler> getListOfHandlers(){
             return this.listOfHandlers;
         }
    }

    public static class LargeTask implements Events {
        public List<Handler> listOfHandlers;
        public LargeTask() {
            super();
            listOfHandlers=new ArrayList<Handler>();
        }
        @Override
        public List<Handler> getListOfHandlers(){
            return this.listOfHandlers;
        }
    }


    public static void main(String[] args){
        EventDispatcher dispatcher = new EventDispatcher();
        Events small=new SmallTask();
        Events large=new LargeTask();

        dispatcher.registerChannel(small,new Handler(){
            @Override
            public void dispatch(Events content) {
                System.out.println("doing a small task 1!");
            }
        });

        dispatcher.registerChannel(small,new Handler(){
            @Override
            public void dispatch(Events content) {
                System.out.println("doing a small task 2!");
            }
        });

        dispatcher.registerChannel(small,new Handler(){
            @Override
            public void dispatch(Events content) {
                System.out.println("doing a small task 3!");
            }
        });
        dispatcher.registerChannel(large,new Handler(){
            @Override
            public void dispatch(Events content) {
                System.out.println("doing a large task 1!");
            }
        });
        dispatcher.registerChannel(large,new Handler(){
            @Override
            public void dispatch(Events content) {
                System.out.println("doing a large task 2!");
            }
        });
        dispatcher.dispatch(small);
        dispatcher.dispatch(large);
        }
}

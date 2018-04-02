import java.util.*;

public class EventDispatcher {
    private HashMap<Events, List<Handler>> handlers;

    public EventDispatcher() {
            handlers = new HashMap<Events, List<Handler>>();
    }
    public void registerChannel(Events content, Handler handler) {
        List<Handler> l= content.getListOfHandlers();
        l.add(handler);
        handlers.put(content,l);
    }

    public void dispatch(Events content) {
        for (int i=0;i<(handlers.get(content)).size();i++){
           (handlers.get(content)).get(i).dispatch(content);
       }
    }
}



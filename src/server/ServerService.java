package server;

import GUI.ServerUI;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.IOException;

public class ServerService extends Service<ServerUI> {
    ServerUI s;

    public ServerService(ServerUI s)
    {
        this.s = s;
    }

    @Override
    protected Task<ServerUI> createTask() {
        // TODO Auto-generated method stub

        return new Task <ServerUI>()
        {
            @Override
            protected ServerUI call() throws Exception {
                System.out.println("YURI");
                new ServerEnd(s);
                return s;
            }
        };

    }

}
package threadpermessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static int DEFAULT_PORT = 12345;
    private static ServerSocket server;

    public static void start() throws IOException
    {
        start(DEFAULT_PORT);
    }

    public static void start(int port) throws IOException
    {
        if (server != null) {
            return;
        }
        try
        {
            server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();

                long start = System.currentTimeMillis();
                new Thread(new ServerHandler(socket)).start();
                long end = System.currentTimeMillis();

                System.out.println("Spend time is " + (end - start));
            }
        } finally
        {
            if (server != null) {
                System.out.println("服务器已关闭.");
                server.close();
            }
        }
    }

    public static void main(String[] args)
    {
        new Thread(() -> {
            try {
                Server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

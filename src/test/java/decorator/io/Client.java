package decorator.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class Client
{
    @Test
    public void test() throws IOException
    {
        try (InputStream in = new BufferedInputStream(new FileInputStream("src/readme.txt"))) {
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        }
    }
}

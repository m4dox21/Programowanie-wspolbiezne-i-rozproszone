import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedInputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        PipedOutputStream p1Out = new PipedOutputStream();
        PipedOutputStream p2Out = new PipedOutputStream();
        PipedOutputStream p3Out = new PipedOutputStream();
        PipedInputStream p1In = new PipedInputStream();
        PipedInputStream p2In = new PipedInputStream();
        PipedInputStream p3In = new PipedInputStream();
        PipedOutputStream p4Out = new PipedOutputStream();
        PipedInputStream p4In = new PipedInputStream();
        PipedOutputStream p5Out = new PipedOutputStream();
        PipedInputStream p5In = new PipedInputStream();

        p1Out.connect(p1In);
        p2Out.connect(p2In);
        p3Out.connect(p3In);
        p4Out.connect(p4In);
        p5Out.connect(p5In);

        ProcessP1 p1 = new ProcessP1(p1Out);
        ProcessP2 p2 = new ProcessP2(p2Out);
        ProcessP3 p3 = new ProcessP3(p3Out);
        ProcessP4 p4 = new ProcessP4(p4In, p4Out);
        ProcessP5 p5 = new ProcessP5(p5In);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}

package traffic;

public class QueueThread extends Thread {

    @Override
    public void run() {
        this.setName("QueueThread");
    }
}

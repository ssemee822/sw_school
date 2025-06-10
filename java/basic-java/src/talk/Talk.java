package talk;

public class Talk {
    private String to;
    private String message;
    private NetworkAdapter adapter;

    public Talk(String to, NetworkAdapter adapter) {
        this.to = to;
        this.adapter = adapter;
    }

    public void writeMsg(String msg) {
        this.message = msg;
    }

    public void sendMsg() {
        adapter.connect();
        adapter.send(to +": "+ message);
    }
}

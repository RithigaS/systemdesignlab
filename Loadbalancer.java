class Service {
    String name;
    boolean alive = true;

    Service(String n) {
        name = n;
    }
}

class LoadBalancer {
    Service s1, s2;

    LoadBalancer(Service a, Service b) {
        s1 = a;
        s2 = b;
    }

    Service route() {
        if (s1.alive)
            return s1;
        else if (s2.alive)
            return s2;
        return null;
    }
}

public class Main {
    public static void main(String[] args) {

        Service a = new Service("Service-A");
        Service b = new Service("Service-B");

        LoadBalancer lb = new LoadBalancer(a, b);

        for (int i = 1; i <= 6; i++) {

            if (i > 3)
                a.alive = false; // failover

            Service s = lb.route();

            System.out.println("Request " + i +
                    " routed to " + s.name);
        }
    }
}

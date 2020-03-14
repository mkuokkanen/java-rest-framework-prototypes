package fi.mkuokkanen.webproto.pippo;

import ro.pippo.core.Pippo;

public class PippoMain {

    public static void main(String[] args) {
        Pippo pippo = new Pippo(new PippoApplication());
        pippo.start();
    }
}

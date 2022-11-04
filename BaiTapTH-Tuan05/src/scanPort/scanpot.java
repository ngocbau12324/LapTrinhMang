/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanPort;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author NGOC BAU
 */
public class scanpot {
    public static Future<Boolean> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout) {
  return es.submit(new Callable<Boolean>() {
      @Override public Boolean call() {
        try {
          Socket socket = new Socket();
          socket.connect(new InetSocketAddress(ip, port), timeout);
          socket.close();
          return true;
        } catch (Exception ex) {
          return false;
        }
      }
   });
}
 public static void main(final String... args) throws InterruptedException, ExecutionException {
  final ExecutorService es = Executors.newFixedThreadPool(20);
  final String ip = "8.8.8.8";
  final int timeout = 200;
  final List<Future<Boolean>> futures = new ArrayList<>();
  for (int port = 50; port <= 60; port++) {
    futures.add(portIsOpen(es, ip, port, timeout));
  }
  es.shutdown();
  int openPorts = 0;
  for (final Future<Boolean> f : futures) {
    if (f.get()) {
      openPorts++;
    }
  }
  System.out.println("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of " + timeout + "ms)");
}   
}

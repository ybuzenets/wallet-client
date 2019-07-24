package dev.buzenets.walletclient;

import com.beust.jcommander.JCommander;
import dev.buzenets.walletclient.cli.Args;
import dev.buzenets.walletclient.client.WalletClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static dev.buzenets.walletclient.functions.Functions.RUNNABLE_ROUND;

public class ClientApplication {
    private static final Logger LOG = LogManager.getLogger(ClientApplication.class);

    public static void main(String[] argv) {
        final Args args = new Args();
        JCommander.newBuilder()
            .addObject(args)
            .acceptUnknownOptions(true)
            .build()
            .parse(argv);
        final WalletClient client = new WalletClient(args.getHost(), args.getPort());
        final int users = args.getUsers();
        final int threads = args.getThreads();
        final ExecutorService executorService = Executors.newFixedThreadPool(users * threads);
        final int rounds = args.getRounds();

        for (int round = 0; round < rounds; round++) {
            for (int thread = 0; thread < threads; thread++) {
                for (int user = 1; user <= users; user++) {
                    executorService.submit(RUNNABLE_ROUND.apply(
                        client,
                        (long) user
                    ));
                }
            }
        }
        executorService.shutdown();
    }
}

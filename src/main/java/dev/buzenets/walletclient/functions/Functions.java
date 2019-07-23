package dev.buzenets.walletclient.functions;

import dev.buzenets.walletclient.client.WalletClient;
import dev.buzenets.walletclient.rounds.Round;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Functions {
    private static final Supplier<Round> ROUND_SUPPLIER
        = () -> Round.values()[ThreadLocalRandom.current()
        .nextInt(3)];

    public static final BiFunction<WalletClient, Long, Runnable> RUNNABLE_ROUND
        = (client, user) -> () -> ROUND_SUPPLIER.get()
        .accept(client, user);
}

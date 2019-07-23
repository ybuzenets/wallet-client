package dev.buzenets.walletclient.benchmark;

import dev.buzenets.walletclient.client.WalletClient;
import dev.buzenets.walletserver.grpc.CURRENCY;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class ClientBenchmark {

    private static final WalletClient WALLET_CLIENT = new WalletClient("127.0.0.1", 6565);

    @Benchmark
    @Threads(Threads.MAX)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public void benchmarkDeposits() {
        WALLET_CLIENT.makeDeposit(1L, "100.00", CURRENCY.EUR);
    }

    @Benchmark
    @Threads(Threads.MAX)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public void benchmarkWithdraws() {
        WALLET_CLIENT.makeWithdrawal(1L, "100.00", CURRENCY.EUR);
    }

    @Benchmark
    @Threads(Threads.MAX)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Fork(1)
    public void benchmarkRetrievingBalance() {
        WALLET_CLIENT.getBalance(1L);
    }
}

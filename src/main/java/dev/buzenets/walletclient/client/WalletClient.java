package dev.buzenets.walletclient.client;

import dev.buzenets.walletserver.grpc.BalanceSummary;
import dev.buzenets.walletserver.grpc.CURRENCY;
import dev.buzenets.walletserver.grpc.WalletGrpc;
import dev.buzenets.walletserver.grpc.WalletRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class WalletClient {

    private static final Logger LOG = LogManager.getLogger(WalletClient.class);
    //TODO: try using asynchronous stub.
    // For now the main method exits before the requests using async stub even get sent
    private final WalletGrpc.WalletBlockingStub stub;

    public WalletClient(String host, int port) {
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
            .usePlaintext()
            .build();
        stub = WalletGrpc.newBlockingStub(channel);
    }

    public void makeDeposit(Long user, String amount, CURRENCY currency) {
        WalletRequest request = WalletRequest.newBuilder()
            .setUser(user)
            .setAmount(amount)
            .setCurrency(currency)
            .build();

        try {
            stub.deposit(request);
            LOG.info(
                "Deposit of {} {} for user with id {} completed successfully",
                amount,
                currency.toString(),
                user
            );
        } catch (StatusRuntimeException e) {
            LOG.error(
                "Could not deposit {} {} for user with id {}, cause: {}",
                amount,
                currency.toString(),
                user,
                e.getStatus()
                    .getDescription()
            );
        }
    }

    public void makeWithdrawal(Long user, String amount, CURRENCY currency) {
        WalletRequest request = WalletRequest.newBuilder()
            .setUser(user)
            .setAmount(amount)
            .setCurrency(currency)
            .build();

        try {
            stub.withdraw(request);
            LOG.info(
                "Withdrawal of {} {} for user with id {} completed successfully",
                amount,
                currency.toString(),
                user
            );
        } catch (StatusRuntimeException e) {
            LOG.error(
                "Could not withdraw {} {} for user with id {}, cause: {}",
                amount,
                currency.toString(),
                user,
                e.getStatus()
                    .getDescription()
            );
        }
    }

    public void getBalance(Long user) {
        WalletRequest request = WalletRequest.newBuilder()
            .setUser(user)
            .build();
        final BalanceSummary balance = stub.balance(request);
        final Map<String, String> amountMap = balance.getAmountMap();
       LOG.info(
            "Balance request for user with id {} completed\n" + "Available funds: {}",
            user,
            amountMap
        );
    }
}

package dev.buzenets.walletclient.rounds;

import dev.buzenets.walletclient.client.WalletClient;
import dev.buzenets.walletserver.grpc.CURRENCY;

import java.util.function.BiConsumer;

public enum Round implements BiConsumer<WalletClient, Long> {
    A {
        @Override
        public void accept(WalletClient client, Long user) {
            client.makeDeposit(user, "100.00", CURRENCY.USD);
            client.makeWithdrawal(user, "200.00", CURRENCY.USD);
            client.makeDeposit(user, "100.00", CURRENCY.EUR);
            client.getBalance(user);
            client.makeWithdrawal(user, "100.00", CURRENCY.USD);
            client.getBalance(user);
            client.makeWithdrawal(user, "100.00", CURRENCY.USD);
        }
    }, B {
        @Override
        public void accept(WalletClient client, Long user) {
            client.makeWithdrawal(user, "100.00", CURRENCY.GBP);
            client.makeDeposit(user, "300.00", CURRENCY.GBP);
            client.makeWithdrawal(user, "100.00", CURRENCY.GBP);
            client.makeWithdrawal(user, "100.00", CURRENCY.GBP);
            client.makeWithdrawal(user, "100.00", CURRENCY.GBP);
        }
    }, C {
        @Override
        public void accept(WalletClient client, Long user) {
            client.getBalance(user);
            client.makeDeposit(user, "100.00", CURRENCY.USD);
            client.makeDeposit(user, "100.00", CURRENCY.EUR);
            client.makeWithdrawal(user, "100.00", CURRENCY.USD);
            client.makeDeposit(user, "100.00", CURRENCY.EUR);
            client.getBalance(user);
            client.makeWithdrawal(user, "200.00", CURRENCY.USD);
            client.getBalance(user);
        }
    };

    @Override
    public void accept(WalletClient client, Long user) {
        throw new UnsupportedOperationException();
    }
}

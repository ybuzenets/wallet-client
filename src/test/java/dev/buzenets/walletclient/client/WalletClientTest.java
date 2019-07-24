package dev.buzenets.walletclient.client;

import dev.buzenets.walletserver.grpc.BalanceSummary;
import dev.buzenets.walletserver.grpc.CURRENCY;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Yury Buzenets on 24.07.2019.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WalletClientTest {
    private static final long userId = -1L;
    private final WalletClient client = new WalletClient("walletserver.buzenets.dev", 6565);

    @AfterAll
    void tearDown() {
        final BalanceSummary balance = client.getBalance(userId);
        balance.getAmountMap()
            .forEach((currency, value) -> client.makeWithdrawal(userId,
                value,
                CURRENCY.valueOf(currency)
            ));
    }


    @Test
    @Order(1)
    void withdrawFromEmptyWallet() {
        final String result = client.makeWithdrawal(userId, "200", CURRENCY.USD);
        assertEquals("Insufficient funds", result);
    }

    @Test
    @Order(2)
    void depositIntoEmptyWallet() {
        final BigDecimal expected = new BigDecimal("100");
        client.makeDeposit(userId, expected.toString(), CURRENCY.USD);
        final BalanceSummary balance = client.getBalance(userId);
        final BigDecimal actual = new BigDecimal(balance.getAmountMap()
            .get(CURRENCY.USD.toString()));
        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    @Order(3)
    void withdrawInsufficientFundsFromNonEmptyWallet() {
        final String result = client.makeWithdrawal(userId, "200", CURRENCY.USD);
        assertEquals("Insufficient funds", result);
    }

    @Test
    @Order(4)
    void depositAnotherCurrency() {
        final BigDecimal expected = new BigDecimal("100");
        client.makeDeposit(userId, expected.toString(), CURRENCY.EUR);
        final BalanceSummary balance = client.getBalance(userId);
        final Map<String, String> balances = balance.getAmountMap();
        final BigDecimal dollars = new BigDecimal(balances.get(CURRENCY.USD.toString()));
        final BigDecimal euros = new BigDecimal(balances.get(CURRENCY.EUR.toString()));
        assertEquals(0, dollars.compareTo(expected));
        assertEquals(0, euros.compareTo(expected));
    }

    @Test
    @Order(5)
    void withdrawInsufficientFundsFromNonEmptyWalletWithMultipleCurrencies() {
        final String result = client.makeWithdrawal(userId, "200", CURRENCY.USD);
        assertEquals("Insufficient funds", result);
    }

    @Test
    @Order(6)
    void depositIntoNonEmptyWallet() {
        final BigDecimal toDeposit = new BigDecimal("100");
        final BigDecimal expected = new BigDecimal("200");
        client.makeDeposit(userId, toDeposit.toString(), CURRENCY.USD);
        final BalanceSummary balance = client.getBalance(userId);
        final BigDecimal actual = new BigDecimal(balance.getAmountMap()
            .get(CURRENCY.USD.toString()));
        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    @Order(7)
    void finalWithdraw() {
        final BigDecimal expected = new BigDecimal("100");
        client.makeWithdrawal(userId, "200", CURRENCY.USD);
        final BalanceSummary balance = client.getBalance(userId);
        final Map<String, String> balances = balance.getAmountMap();
        final BigDecimal dollars = new BigDecimal(balances.get(CURRENCY.USD.toString()));
        final BigDecimal euros = new BigDecimal(balances.get(CURRENCY.EUR.toString()));
        assertEquals(0, dollars.compareTo(BigDecimal.ZERO));
        assertEquals(0, expected.compareTo(euros));
    }
}
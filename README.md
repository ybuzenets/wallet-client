# Wallet client #

Client implementation for the server implemented in https://github.com/ybuzenets/wallet

# Setup #

First you need to package the jar
```
./gradlew build
```
Then run the jar using
```
java -jar walletclient-1.0.jar
```
Avaiable command line options
* **-h**, **--hostname**: hostname of the server (The client connects to the test instance deployed to walletserver.buzenets.dev if this parameter is not specified)
* **-p**, **--port**: port number (Default value: 6565)
* **-u**, **--users**: Number of concurrent users (Default: 1)
* **-t, --threads**: Number of threads per user (Default: 1)
* **-r, --rounds**: Number of rounds per thread (Default: 1)

The results will be logged into `build/log/wallet-client.log` file and console output

# Rounds #
*Please note that not all rounds leave the wallet in a state it was before starting a round*
* Round A
  * Deposit 100 USD
  * Withdraw 200 USD
  * Deposit 100 EUR
  * Get Balance
  * Withdraw 100 USD
  * Get Balance
  * Withdraw 100 USD
* Round B
  * Withdraw 100 GBP
  * Deposit 300 GPB
  * Withdraw 100 GBP
  * Withdraw 100 GBP
  * Withdraw 100 GBP
* Round C
  * Get Balance
  * Deposit 100 USD
  * Deposit 100 USD
  * Withdraw 100 USD
  * Deposit 100 USD
  * Get Balance
  * Withdraw 200 USD
  * Get Balance


# Performance benchmark results #

Avg. ops/second*
* 156,302 for deposit
* 100,913 for withdraw
* 1,805,345 for retrieving balance

*numbers measured by JMH (1 fork, 5 warm-up iterations, 5 measurement iterations, `Runtime
.getRuntime().availableProcessors()` number of threads)

Hardware:
* CPU: Intel Core i3-8100 (4 cores, 3600 MHz)
* RAM: G.Skill Aegis 16GB (dual channel, 3000 Mhz, CL16)
* SSD: Intenso TOP 256 GB (400 MB/s write, 520 MB/s read)

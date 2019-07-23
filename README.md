# Wallet client #

Client implementation for the server implemented in https://github.com/ybuzenets/wallet

# Running instructions #

First you need to package the jar
```
./gradlew build
```
Then run the jar using
```
java -jar walletclient-1.0.jar
```
The results will be logged into `build/log/wallet-client.log` file and console

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
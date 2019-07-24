package dev.buzenets.walletclient.cli;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import lombok.Getter;

@Parameters
public class Args {

    @Getter
    @Parameter(names = {"-h", "--host"}, description = "Wallet server hostname")
    private String host = "walletserver.buzenets.dev";

    @Getter
    @Parameter(names = {"-p", "--port"}, description = "Wallet server port")
    private int port = 6565;

    @Getter
    @Parameter(names = {"-u", "--users"}, description = "Number of concurrent users")
    private int users = 1;

    @Getter
    @Parameter(names = {"-t", "--threads"}, description = "Threads per user")
    private int threads = 1;

    @Getter
    @Parameter(names = {"-r", "--rounds"}, description = "Rounds per thread")
    private int rounds = 1;
}

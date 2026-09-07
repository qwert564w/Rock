package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.auth.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import rockstar.client.internal.network.NetworkInternal004;
import rockstar.client.internal.core.CoreInternal017;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.auth.OAuthToken;
import rockstar.client.internal.auth.AuthInternal028;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.network.RockstarHttpResponse;

public class AuthInternal032
extends AuthInternal028 {
    private final Consumer<URL> internalField0922;
    private final int internalField0227;

    public AuthInternal032(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, Consumer<URL> consumer) {
        this(typedValue034, typedValue071, consumer, 300000);
    }

    public AuthInternal032(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, Consumer<URL> consumer, int n) {
        super(typedValue034, typedValue071);
        if (this.internalField0727.internalMethod08847() == null) {
            throw new IllegalArgumentException("The application config must have a redirect uri set");
        }
        this.internalField0922 = consumer;
        this.internalField0227 = n;
    }

    /*
     * Exception decompiling
     */
    @Override
    public OAuthToken internalMethod04761() throws IOException, InterruptedException, TimeoutException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.getMainStacks().getMainStacks()(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static /* synthetic */ void internalMethod03298(CompletableFuture completableFuture, HttpExchange httpExchange) throws IOException {
        try {
            NetworkInternal004.InternalType0484 nestedValue0172 = NetworkInternal004.internalMethod01262(httpExchange.getRequestURI()).internalMethod00462();
            Optional<String> optional = nestedValue0172.internalMethod06443("error");
            Optional<String> optional2 = nestedValue0172.internalMethod06443("error_description");
            if (optional.isPresent() && optional2.isPresent()) {
                RockstarHttpResponse typedValue035 = new RockstarHttpResponse(null, 500, new byte[0], Collections.emptyMap());
                throw new CoreInternal017(typedValue035, optional.get(), optional2.get());
            }
            Optional<String> optional3 = nestedValue0172.internalMethod06443("code");
            if (!optional3.isPresent()) {
                throw new IllegalStateException("Failed to extract auth code from response url");
            }
            byte[] byArray = "You have been logged in! You can now close this window.".getBytes(StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(200, byArray.length);
            httpExchange.getResponseBody().write(byArray);
            httpExchange.close();
            completableFuture.complete(optional3.get());
        }
        catch (Throwable throwable) {
            byte[] byArray = ("Login failed. Error message: " + throwable.getMessage()).getBytes(StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(500, byArray.length);
            httpExchange.getResponseBody().write(byArray);
            httpExchange.close();
            completableFuture.completeExceptionally(throwable);
        }
    }
}


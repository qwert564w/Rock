package rockstar.client.internal.auth;






import rockstar.client.network.*;
import rockstar.client.auth.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.core.*;
import rockstar.client.*;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import rockstar.client.internal.network.NetworkInternal004;
import rockstar.client.internal.core.CoreInternal017;
import rockstar.client.auth.OAuthClientConfig;
import rockstar.client.auth.OAuthToken;
import rockstar.client.internal.auth.AuthInternal024;
import rockstar.client.internal.auth.AuthInternal028;
import rockstar.client.network.RockstarHttpClient;
import rockstar.client.network.RockstarHttpResponse;

public class AuthInternal031
extends AuthInternal028 {
    private final Consumer<JFrame> internalField0922;
    private final Consumer<JFrame> internalField0921;
    private final int internalField0227;

    public AuthInternal031(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071) {
        this(typedValue034, typedValue071, jFrame -> jFrame.setVisible(true), Window::dispose);
    }

    public AuthInternal031(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, Consumer<JFrame> consumer, Consumer<JFrame> consumer2) {
        this(typedValue034, typedValue071, consumer, consumer2, 300000);
    }

    public AuthInternal031(RockstarHttpClient typedValue034, OAuthClientConfig typedValue071, Consumer<JFrame> consumer, Consumer<JFrame> consumer2, int n) {
        super(typedValue034, typedValue071);
        this.internalField0922 = consumer;
        this.internalField0921 = consumer2;
        this.internalField0227 = n;
    }

    @Override
    public OAuthToken internalMethod04761() throws IOException, InterruptedException, TimeoutException {
        URL uRL = NetworkInternal004.internalMethod02979(this.internalField0727.internalMethod01376().internalMethod06755()).internalMethod00462().internalMethod01498(this.internalField0727.internalMethod00213()).internalMethod06913().internalMethod02292();
        final CompletableFuture completableFuture = new CompletableFuture();
        JFXPanel jFXPanel = new JFXPanel();
        JFrame jFrame = new JFrame("MinecraftAuth - Microsoft Login");
        jFrame.setDefaultCloseOperation(0);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setContentPane((Container)jFXPanel);
        jFrame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (!completableFuture.isDone()) {
                    completableFuture.completeExceptionally(new InternalType0075());
                }
            }
        });
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.setContextMenuEnabled(false);
            this.internalField0058.internalMethod04855("User-Agent").ifPresent(arg_0 -> ((WebEngine)webView.getEngine()).setUserAgent(arg_0));
            webView.getEngine().load(uRL.toString());
            webView.getEngine().locationProperty().addListener((observableValue, string, string2) -> {
                try {
                    NetworkInternal004.InternalType0484 nestedValue0172 = NetworkInternal004.internalMethod07963(string2).internalMethod00462();
                    Optional<String> optional = nestedValue0172.internalMethod06443("error");
                    Optional<String> optional2 = nestedValue0172.internalMethod06443("error_description");
                    if (optional.isPresent() && optional2.isPresent()) {
                        RockstarHttpResponse typedValue035 = new RockstarHttpResponse(null, 500, new byte[0], Collections.emptyMap());
                        throw new CoreInternal017(typedValue035, optional.get(), optional2.get());
                    }
                    nestedValue0172.internalMethod06443("code").ifPresent(completableFuture::complete);
                }
                catch (Throwable throwable) {
                    completableFuture.completeExceptionally(throwable);
                }
            });
            jFXPanel.setScene(new Scene((Parent)webView, (double)jFrame.getWidth(), (double)jFrame.getHeight()));
            this.internalField0922.accept(jFrame);
        });
        try {
            String string = (String)completableFuture.get(this.internalField0227, TimeUnit.MILLISECONDS);
            OAuthToken typedValue074 = (OAuthToken)this.internalField0058.internalMethod07532(new AuthInternal024(this.internalField0727, string));
            return typedValue074;
        }
        catch (TimeoutException timeoutException) {
            throw new TimeoutException("Login timed out");
        }
        catch (ExecutionException executionException) {
            if (executionException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)executionException.getCause();
            }
            throw new RuntimeException(executionException);
        }
        finally {
            this.internalField0921.accept(jFrame);
        }
    }

    public static class InternalType0075
    extends RuntimeException {
        public InternalType0075() {
            super("User closed the login window");
        }
    }
}


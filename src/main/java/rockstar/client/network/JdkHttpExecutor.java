package rockstar.client.network;


import rockstar.client.*;
import rockstar.client.internal.network.*;
import rockstar.client.internal.core.*;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;

public class JdkHttpExecutor extends HttpExecutor {
   public JdkHttpExecutor(RockstarHttpClient localValue1) {
      super(localValue1);
   }

   @Nonnull
   @Override
   public RockstarHttpResponse internalMethod03072(@Nonnull RockstarHttpRequest localValue1) throws IOException {
      ExecutorService localValue2 = Executors.newCachedThreadPool();
      HttpClient localValue3 = null;
      boolean localValue4 = true;

      RockstarHttpResponse localValue8;
      try {
         localValue3 = this.internalMethod01504(localValue1, localValue2);
         HttpRequest localValue5 = this.internalMethod06526(localValue1);
         if (!localValue1.internalMethod07965()) {
            HttpResponse localValue12 = this.internalMethod06044(localValue3, localValue5, BodyHandlers.ofByteArray());
            return new RockstarHttpResponse(new NetworkInternal004(localValue12.uri()).internalMethod02292(), localValue12.statusCode(), (byte[])localValue12.body(), localValue12.headers().map());
         }

         HttpResponse localValue6 = this.internalMethod06044(localValue3, localValue5, BodyHandlers.ofInputStream());
         CoreInternal009 localValue7 = new CoreInternal009((InputStream)localValue6.body(), this.internalMethod04045(localValue2, localValue3));
         localValue4 = false;
         localValue8 = new RockstarHttpResponse(new NetworkInternal004(localValue6.uri()).internalMethod02292(), localValue6.statusCode(), localValue7, localValue6.headers().map());
      } finally {
         if (localValue4) {
            this.internalMethod04045(localValue2, localValue3).close();
         }
      }

      return localValue8;
   }

   private HttpClient internalMethod01504(RockstarHttpRequest localValue1, Executor localValue2) throws IOException {
      Builder localValue3 = HttpClient.newBuilder().executor(localValue2);
      CookieManager localValue4 = this.internalMethod04792(localValue1);
      if (localValue4 != null) {
         localValue3.cookieHandler(localValue4);
      }

      if (this.internalMethod01771(localValue1)) {
         localValue3.sslContext(InsecureSslContext.internalMethod03802());
      }

      localValue3.connectTimeout(Duration.ofMillis(this.internalField0058.internalMethod03722()));
      switch (localValue1.internalMethod03460()) {
         case internalField0530:
            localValue3.followRedirects(this.internalField0058.internalMethod03723() ? Redirect.NORMAL : Redirect.NEVER);
            break;
         case internalField0531:
            localValue3.followRedirects(Redirect.NORMAL);
            break;
         case internalField1191:
            localValue3.followRedirects(Redirect.NEVER);
      }

      if (this.internalField0058.internalMethod03513().internalMethod01161()) {
         if (!ProxyType.internalField0273.equals(this.internalField0058.internalMethod03513().internalMethod02245())) {
            throw new UnsupportedOperationException("The Java 11 HttpClient only supports HTTP proxies");
         }

         localValue3.proxy(this.internalField0058.internalMethod03513().internalMethod02248());
         if (this.internalField0058.internalMethod03513().internalMethod01659() != null && this.internalField0058.internalMethod03513().internalMethod06232() != null) {
            localValue3.authenticator(this.internalField0058.internalMethod03513().internalMethod02247());
         }
      }

      return localValue3.build();
   }

   private HttpRequest internalMethod06526(RockstarHttpRequest localValue1) throws IOException {
      java.net.http.HttpRequest.Builder localValue2 = HttpRequest.newBuilder();
      localValue2.uri(new NetworkInternal004(localValue1.internalMethod03635()).internalMethod02291());
      localValue2.timeout(Duration.ofMillis(this.internalField0058.internalMethod03729()));
      BodyPublisher localValue3;
      if (localValue1 instanceof CustomHttpRequest && ((CustomHttpRequest)localValue1).internalMethod01029()) {
         RequestBody localValue4 = ((CustomHttpRequest)localValue1).internalMethod05540();
         if (localValue1.internalMethod02703()) {
            InputStream localValue5 = localValue4.internalMethod02044();
            localValue3 = BodyPublishers.ofInputStream(() -> localValue5);
         } else {
            localValue3 = BodyPublishers.ofByteArray(localValue4.internalMethod03451());
         }
      } else {
         localValue3 = BodyPublishers.noBody();
      }

      localValue2.method(localValue1.internalMethod06034(), localValue3);

      for (Entry localValue9 : this.internalMethod00896(localValue1, null).entrySet()) {
         if (!((String)localValue9.getKey()).equalsIgnoreCase("Content-Length")) {
            for (String localValue7 : (Iterable<String>)(Iterable<?>)(List)localValue9.getValue()) {
               localValue2.header((String)localValue9.getKey(), localValue7);
            }
         }
      }

      return localValue2.build();
   }

   private <T> HttpResponse<T> internalMethod06044(HttpClient localValue1, HttpRequest localValue2, BodyHandler<T> localValue3) throws IOException {
      try {
         return localValue1.send(localValue2, localValue3);
      } catch (InterruptedException localValue5) {
         throw new IOException("Request interrupted", localValue5);
      }
   }

   private CoreInternal009.InternalType0485 internalMethod04045(ExecutorService localValue1, HttpClient localValue2) {
      return () -> {
         localValue1.shutdownNow();
         if (localValue2 instanceof Closeable) {
            ((Closeable)localValue2).close();
         }
      };
   }
}

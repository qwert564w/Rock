package rockstar.client.network;


import rockstar.client.*;
import rockstar.client.internal.network.*;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.ssl.SslContextBuilder;
import java.io.IOException;
import java.net.CookieManager;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClient.RequestSender;
import reactor.netty.tcp.SslProvider;
import reactor.netty.transport.ProxyProvider.AddressSpec;
import reactor.netty.transport.ProxyProvider.Builder;
import reactor.netty.transport.ProxyProvider.Proxy;

public class AlternativeHttpExecutor extends HttpExecutor {
   private static final byte[] internalField0609 = new byte[0];

   public AlternativeHttpExecutor(RockstarHttpClient localValue1) {
      super(localValue1);
   }

   @Nonnull
   @Override
   public RockstarHttpResponse internalMethod03072(@Nonnull RockstarHttpRequest localValue1) throws IOException {
      CookieManager localValue2 = this.internalMethod04792(localValue1);
      HttpClient localValue3 = this.internalMethod07282(localValue1, localValue2);
      RequestSender localValue4 = (RequestSender)localValue3.request(HttpMethod.valueOf(localValue1.internalMethod06034()))
         .uri(NetworkInternal004.internalMethod03347(localValue1.internalMethod03635()).internalMethod02291());
      HttpClient.ResponseReceiver<?> localValue5 = localValue4;
      if (localValue1 instanceof CustomHttpRequest) {
         CustomHttpRequest localValue6 = (CustomHttpRequest)localValue1;
         if (localValue6.internalMethod05540() != null) {
            localValue5 = localValue4.send(ByteBufFlux.fromInbound(Flux.just(localValue6.internalMethod05540().internalMethod03451())));
         }
      }

      try {
         return (RockstarHttpResponse)localValue5.responseSingle((localValue2x, localValue3x) -> {
            try {
               URL localValue4x = NetworkInternal004.internalMethod02979(localValue2x.resourceUrl()).internalMethod02292();
               Map localValue5x = this.internalMethod02223(localValue2x.responseHeaders());
               this.internalMethod05879(localValue2, localValue4x, localValue5x);
               return localValue3x.asByteArray().defaultIfEmpty(internalField0609).map(localValue3xx -> new RockstarHttpResponse(localValue4x, localValue2x.status().code(), localValue3xx, localValue5x));
            } catch (Throwable localValue6x) {
               return Mono.error(localValue6x);
            }
         }).blockOptional().orElseThrow(() -> new IOException("Response is null"));
      } catch (Throwable localValue8) {
         for (Throwable localValue7 = localValue8; localValue7 != null; localValue7 = localValue7.getCause()) {
            if (localValue7 instanceof IOException) {
               throw (IOException)localValue7;
            }
         }

         throw new IOException("Failed to execute request", localValue8);
      }
   }

   private HttpClient internalMethod07282(RockstarHttpRequest localValue1, CookieManager localValue2) throws IOException {
      Map localValue3 = this.internalMethod00896(localValue1, localValue2);
      HttpClient localValue4 = HttpClient.create()
         .responseTimeout(Duration.ofMillis(this.internalField0058.internalMethod03729()))
         .followRedirect(this.internalMethod00904(localValue1))
         .headers(localValue2x -> this.internalMethod01949(localValue3, localValue2x::set, localValue2x::add));
      if (this.internalMethod01771(localValue1)) {
         localValue4 = localValue4.secure(SslProvider.builder().sslContext(SslContextBuilder.forClient().trustManager(new InsecureSslContext()).build()).build());
      }

      if (this.internalField0058.internalMethod03513().internalMethod01161()) {
         ProxyConfig localValue5 = this.internalField0058.internalMethod03513();
         localValue4 = (HttpClient)localValue4.proxy(localValue1x -> {
            AddressSpec localValue2x;
            switch (localValue5.internalMethod02245()) {
               case internalField0273:
                  localValue2x = localValue1x.type(Proxy.HTTP);
                  break;
               case internalField0272:
                  localValue2x = localValue1x.type(Proxy.SOCKS4);
                  break;
               case internalField1098:
                  localValue2x = localValue1x.type(Proxy.SOCKS5);
                  break;
               default:
                  throw new IllegalArgumentException("Unsupported proxy type: " + localValue5.internalMethod02245());
            }

            Builder localValue3x = localValue2x.address((java.net.InetSocketAddress)localValue5.internalMethod07403());
            if (localValue5.internalMethod01659() != null) {
               localValue3x.username(localValue5.internalMethod01659());
            }

            if (localValue5.internalMethod06232() != null) {
               localValue3x.password(localValue1xx -> localValue5.internalMethod06232());
            }
         });
      }

      return localValue4;
   }

   private Map<String, List<String>> internalMethod02223(HttpHeaders localValue1) {
      HashMap<String, List<String>> localValue2 = new HashMap<>();

      for (Entry localValue4 : localValue1.entries()) {
         localValue2.computeIfAbsent((String)localValue4.getKey(), localValue0 -> new ArrayList<>()).add((String)localValue4.getValue());
      }

      return localValue2;
   }
}
